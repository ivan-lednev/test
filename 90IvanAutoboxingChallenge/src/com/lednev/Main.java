package com.lednev;

import java.util.ArrayList;

public class Main {

    private static Bank priorBank = new Bank("Prior Bank");
    private static Customer petr = new Customer("Petr", 200.20);

    public static void main(String[] args) {
        priorBank.addBranch("Radialnaya, 34");
        priorBank.addCustomer("Radialnaya, 34", "Ivan Ivanov", 10.45);
        priorBank.addTransaction("Radialnaya, 34", "Ivan Ivanov", 1200.45);
        priorBank.addCustomer("Radialnaya, 34", "Petr Petrov", 2200.90);
        priorBank.addTransaction("Radialnaya, 34", "Petr Petrov", -1800.9);
        priorBank.showCustomersInBranch("Radialnaya, 34");

    }

}
