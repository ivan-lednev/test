package com.lednev;

import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name){
        this(name, 0);
        this.name = name;
    }

    public Customer(String name, double initialSum){
        this.name = name;
        this.transactions = new ArrayList<Double>();
        this.transactions.add(initialSum);  // For some reason, I wasn't able to use it with an index
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addTransaction(double sum){

        // Java converts a double to an object automatically here
        transactions.add(sum);
    }

    public void printTransactions(){  // To get the list of transactions we'll have to use a loop

        for(int i = 0; i < transactions.size(); i ++){
            System.out.println("\t" + (i + 1) + ". " + transactions.get(i));
        }
    }
}
