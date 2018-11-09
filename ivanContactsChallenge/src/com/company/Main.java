package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Contacts myContacts = new Contacts();

    public static void main(String[] args) {
        myContacts.addToContactsList("Baba Zina s magazina");
        myContacts.printContactsList();
    }
}
