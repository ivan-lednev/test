package com.lednev;

public class Militia extends Infantry {

    public Militia(String name){
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("Militia > " + this.getName() + " > attack()");
    }

    @Override
    public void move() {
        System.out.println("Militia > "+ this.getName() + " > move()");
    }
}