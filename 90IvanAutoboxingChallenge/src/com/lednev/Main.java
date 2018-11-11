package com.lednev;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank priorBank = new Bank("Prior Bank");

    public static void main(String[] args) {
        printMenu();
        boolean quit = false;
        while(!quit){
            System.out.println("\nEnter a command (enter 1 to see the menu): ");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 1:
                    System.out.println("Printing menu...");
                    printMenu();
                    break;
                case 2:
                    quit = true;;
                    System.out.println("Bye");
                    break;
                case 3:
                    System.out.println("Adding a branch...");
                    addBranch();
                    break;
                case 4:
                    System.out.println("Adding a customer...");
                    addCustomer();
                    break;
                case 5:
                    System.out.println("Adding a transaction...");
                    addTransaction();
                    break;
                case 6:
                    System.out.println("Printing branch customers...");
                    System.out.println("Enter branch name: ");
                    String branch = scanner.nextLine();
                    if(!priorBank.showCustomersInBranch(branch)){
                        System.out.println("Operation failed");
                    };
                    break;
            }
        }
    }



    private static void addTransaction(){
        System.out.println("Enter branch name: ");
        String branch = scanner.nextLine();
        System.out.println("Enter customer name: ");
        String customer = scanner.nextLine();
        System.out.println("Enter transaction sum: ");
        double sum = scanner.nextDouble();
        if(!priorBank.addTransaction(branch, customer, sum)){
            System.out.println("Operation failed");
        };
    }

    private static void addCustomer(){
        System.out.println("Enter branch name: ");
        String branch = scanner.nextLine();
        System.out.println("Enter customer name: ");
        String customer = scanner.nextLine();
        System.out.println("Enter initial deposit sum: ");
        double sum = scanner.nextDouble();
        if(!priorBank.addCustomer(branch, customer, sum)){
            System.out.println("Operation failed");
        };
    }

    private static void addBranch(){
        System.out.println("Please, enter the name of a new branch: ");
        String name = scanner.nextLine();
        if(!priorBank.addBranch(name)){
            System.out.println("Operation failed");
        };
    }

    private static void printMenu(){
        System.out.println("1. To print the menu\n" +
                            "2. To quit\n" +
                            "3. To add a new branch\n" +
                            "4. To add a customer to a branch\n" +
                            "5. To add a transaction for a customer\n" +
                            "6. To show a list of customers in a branch");
    };


}
