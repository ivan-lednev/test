package com.lednev;

public abstract class Infantry {
    private String name;

    public Infantry(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // These methods are just like in interfaces
    public abstract void attack();

    public abstract void move();
}
