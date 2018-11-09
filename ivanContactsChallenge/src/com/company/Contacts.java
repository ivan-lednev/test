package com.company;

import java.util.ArrayList;

public class Contacts {
    private ArrayList<String> contactsList = new ArrayList<String>();

    public ArrayList<String> getContactsList() {
        return contactsList;
    }

    public void addToContactsList(String contact){
        contactsList.add(contact);
    }

    public void printContactsList(){
        System.out.println("You have " + contactsList.size() + " contacts:");
        for(int i = 0; i < contactsList.size(); i ++){
            System.out.println((i + 1) + ". " + contactsList.get(i));
        }
    }
}
