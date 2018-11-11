package com.lednev;

import java.util.ArrayList;

public class Examples {

    public static void main(String[] args) {

        ArrayList<Double> testList = new ArrayList<Double>();

        testList.add(10.23);

        // the operations seem to work although primitive ints are mixed with Doubles
        for(int i = 0; i < 20; i++){
            testList.add(i, 0.01 * i);
            System.out.println(testList.get(i));
        }
    }

}
