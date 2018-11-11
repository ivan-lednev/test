package com.lednev;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public void addBranch(String name){
        branches.add(new Branch(name));
    }

    public void addCustomer(String branchName, String cusomerName, double sum){
        int branchIndex = findBranch(branchName);
        // Is it a reference, or a separate instance?
        Branch branch = branches.get(branchIndex);
        branch.addCustomer(cusomerName, sum);
    }

    public void addTransaction(String branchName, String customerName, double sum){
        int branchIndex = findBranch(branchName);
        Branch branch = branches.get(branchIndex);
        int customerIndex = branch.findCustomer(customerName);
        Customer customer = branch.getCustomers().get(customerIndex);
        customer.addTransaction(sum);
    }

    public void showCustomersInBranch(String branchName){
        int branchIndex = findBranch(branchName);
        Branch branch = branches.get(branchIndex);
        System.out.println("\n*****************\n");
        System.out.println("Branch: " + branch.getName());
        for(int i = 0; i < branch.getCustomers().size(); i++){
            System.out.println("\n*****************\n");
            Customer customer = branch.getCustomers().get(i);
            System.out.println("Customer : " + customer.getName());
            System.out.println("Transactions : ");
            customer.printTransactions();

        }

    }

    private int findBranch(String name){
        for(int i = 0; i < branches.size(); i++){
            Branch branch = branches.get(i);   // We create an instance of the Customer to look through the objects in the list
            if(branch.getName().equals(name)){    // We use .equals() to compare strings
                return i;
            }
        }
        return -1;
    }


}
