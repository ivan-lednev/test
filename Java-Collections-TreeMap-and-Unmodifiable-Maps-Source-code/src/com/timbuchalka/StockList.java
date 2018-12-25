package com.timbuchalka;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dev on 16/02/2016.
 */
public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        /*In a linked hashMap, the items are stored in the order they are added*/
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if(item != null) {
            // check if already have quantities of this item
            /*return a value by the key or the default value*/
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // If there are already stocks on this item, adjust the quantity
            /*He doesn't use equals() because all he wants to check is whether
            * the object is in the same place in memory*/
            if(inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }

            /*Update the map with the new value?*/
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);

        if((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity >0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        /*Is it like returning a copy of the original map to prevent change?*/
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        /*Again, iterating through a map*/
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            /*Get rid of the key*/
            StockItem stockItem = item.getValue();

            /*the name is misleading, because 'value' here refers to the price, not the structure of
            * the map*/
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            /*Gee, we don't print anything here, we just concatenate strings to make one big return message
            * at the end!*/
            s = s + stockItem/*Calls toString()*/ + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value " + totalCost;
    }
}
