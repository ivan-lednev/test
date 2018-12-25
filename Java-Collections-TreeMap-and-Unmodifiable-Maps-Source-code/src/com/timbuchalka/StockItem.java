package com.timbuchalka;

/**
 * Created by dev on 16/02/2016.
 */
public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;
    private int reserved;

    public StockItem(String name, double price) {
        this(name, price, 0); // Now it's chaining
/*
        this.name = name;
        this.price = price;
        this.quantityStock = 0;  // or here (but you wouldn't normally do both).
        this. reserved = 0;
*/
    }

    /*Constructor chaining*/
    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
        this. reserved = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if(price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        /*Just a basic check in case the new number is less than 0*/
        if(newQuantity >=0) {
            this.quantityStock = newQuantity;
        }
    }

    /*We need to override this because we implement comparable. This will allow us to use the item in sorted collections*/
    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if(obj == this) {
            return true;
        }

        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        /*We need to use casting because to override the method we should use Object in the signature*/
        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    /*These two methods need to be overridden when we use objects in hashed collections*/
    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo");
        if(this == o) {
            return 0;
        }

        if(o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }
}
