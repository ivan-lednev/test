package com.lednev;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();

        String stringData = "one two three four five six";

        String[] data = stringData.split(" ");

        for(String s : data){
//            System.out.println(s);
            arrayList.add(s);
        }

        Iterator<String> iterator = arrayList.iterator();

        String test = iterator.next();

        if(iterator.next() != null){
            System.out.println(iterator.next());
        }

        System.out.println(test);
    }
}
