package com.lednev;

import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> customers;
    private String name;

    public Branch(String name){
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(String name){

        // This is where we can test the factory method in Customer
        customers.add(new Customer(name));
    }

    public void addCustomer(String name, double initialSum){
        customers.add(new Customer(name, initialSum));

        // How do we add an initial transaction?
        // We used constructor chaining and overloading
    }

    public void addTransaction(String name, double sum){
        int index = findCustomer(name);
        customers.get(index).addTransaction(sum);   // this call acts as an instance, we can add commands from the Customer class to it

    }

    public int findCustomer(String name){
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);   // We create an instance of the Customer to look through the objects in the list
            if(customer.getName().equals(name)){    // We use .equals() to compare strings
              return i;
            }
        }
        return -1;
    }


}
