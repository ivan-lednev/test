package com.lednev;

import java.util.ArrayList;
import java.util.LinkedList;

public class Demo3 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("hello");

        for(int i = 0; i < 100000; i++){
            linkedList.add(1, "hello");
        }

        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
    }
}
