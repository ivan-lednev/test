package com.lednev;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList{
    private ArrayList<ListItem> items;
    private ListItem head;

    public LinkedList(){
        this.items = new ArrayList<ListItem>();
    }

    public void add(ListItem item){
        items.add(item);
        if (items.size() == 1){
            System.out.println("1st item added: " + item.getValue());
            return;
        }

        Iterator<ListItem> i = items.iterator();

        ListItem next = i.next();

        while(i.hasNext()) {

            if (next.getValue().compareTo(item.getValue()) == 0) {
                System.out.println("LL > add > not added, identical values");
                return;
            } else if (next.getValue().compareTo(item.getValue()) < 0) {
                if (next.getNext() == null) {
                    next.setNext(item);
                    item.setPrevious(next);
                    System.out.println("LL > add > entries connected");
                    return;
                } else {
                    System.out.println("Item in list already has a next");
                    return;
                }
            }
        }

//        else if(head.getValue().compareTo(item.getValue()) < 0) {
//            head.setNext(item);
//        }


    }

}
