package com.lednev;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Demo2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");

        for(int i = 0; i < 100000; i++){
            arrayList.add(1, "hello");
        }

        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
