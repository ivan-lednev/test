package com.lednev;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello!");
        LinkedList<String> toDo = new LinkedList<String>();
        addInOrder(toDo, "four");
        addInOrder(toDo, "three");
        addInOrder(toDo, "two");
        addInOrder(toDo, "one");
        printList(toDo);
        execute(toDo);
    }

    private static void printList(LinkedList<String> list){
        Iterator<String> i = list.iterator();
        while(i.hasNext()){
            // i.next() returns a value and then moves the iterator one step further
            System.out.println("Now doing : " + i.next());
        }
        System.out.println("================================ ");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newTask) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            // without .next, the iterator isn't going to point to any record at the start
            int comparison = stringListIterator.next().compareTo(newTask);
            if (comparison == 0) {
                // equal, do not add
                System.out.println(newTask + " is already included as a task");
                return false;
            } else if (comparison > 0) {
                // new task should appear before this one.
                // Learn Java -> Attend a meeting (this one will give a positive).
                // .next already moved to the next entry, but we should add a new task
                // before the chosen one.
                // With a list iterator you can go back one step.
                stringListIterator.previous();
                stringListIterator.add(newTask);
                // Didn't add this at first, caused  an 'out of memory' exception
                return true;
            } else if (comparison < 0){
                // continue
            }
        }

        stringListIterator.add(newTask);
        return true;

    }

    private static void execute(LinkedList<String> tasks){
        Scanner scanner = new Scanner(System.in);
        ListIterator<String> iterator = tasks.listIterator();
        if (tasks.isEmpty()){
            System.out.println("No tasks found");
            return;
        } else {
            System.out.println("Now doing " + iterator.next());
            printMenu();
        }
        boolean quit = false;
        boolean goingForward = true;
        int choice = 0;
        while(!quit){
            System.out.println("Enter your option:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    System.out.println("Let's go for a break!");
                    quit = true;
                    break;

                case 1:
                    if(goingForward){
                        if(iterator.hasPrevious()){
                            iterator.previous();
                        }
                        goingForward = false;
                    }
                    if(iterator.hasPrevious()){
                        System.out.println("Moving back one task, now doing: ");
                        System.out.println(iterator.previous());
                    } else {
                        System.out.println("We are at the start of the list.");
                        goingForward = true;
                    }
                    break;

                case 2:
                    if(!goingForward){
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                        goingForward = true;
                    }
                    if(iterator.hasNext()){
                        System.out.println("Moving forward, now doing: ");
                        System.out.println(iterator.next());
                    } else {
                        System.out.println("We are at the end of the list.");
                        goingForward = false;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Press 0 to exit" +
                            "\nPress 1 to move backward" +
                            "\nPress 2 to move forward" +
                            "\nPress 3 to print the menu");
    }
}
