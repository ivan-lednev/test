package com.lednev;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String name){
        if(findBranch(name) != -1){
            System.out.println("A branch by that name already exists");
            return false;
        }
        branches.add(new Branch(name));
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double sum){
        int branchIndex = findBranch(branchName);
        if(branchIndex == -1){
            System.out.println("No branch by that name");
            return false;
        }
        // Is it a reference, or a separate instance?
        Branch branch = branches.get(branchIndex);
        branch.addCustomer(customerName, sum);
        return true;
    }

    public boolean addTransaction(String branchName, String customerName, double sum){
        int branchIndex = findBranch(branchName);
        if(branchIndex == -1){
            System.out.println("No branch by that name");
            return false;
        }
        Branch branch = branches.get(branchIndex);
        int customerIndex = branch.findCustomer(customerName);
        if(customerIndex == -1){
            System.out.println("No customer by that name");
            return false;
        }
        Customer customer = branch.getCustomers().get(customerIndex);
        customer.addTransaction(sum);
        return true;
    }

    public boolean showCustomersInBranch(String branchName){
        int branchIndex = findBranch(branchName);
        if(branchIndex == -1){
            System.out.println("No branch by that name");
            return false;
        }
        Branch branch = branches.get(branchIndex);
        System.out.println("\n*****************\n");
        System.out.println("Branch : " + branch.getName());
        for(int i = 0; i < branch.getCustomers().size(); i++){
            System.out.println("\n*****************\n");
            Customer customer = branch.getCustomers().get(i);
            System.out.println("Customer : " + customer.getName());
            System.out.println("\n*****************\n");
            System.out.println("Transactions : ");
            customer.printTransactions();

        }
        return true;

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
