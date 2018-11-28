package com.lednev;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListItem minsk = new ListItem("Minsk");
        ListItem tahiti = new ListItem("Tahiti");

        list.add(minsk);
        list.add(tahiti);
        System.out.println("After minsk there is " + minsk.getNext().getValue());
        System.out.println("Before tahiti there is " + tahiti.getPrevious().getValue());

    }
}
