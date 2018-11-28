package com.lednev;

public abstract class Scout extends Infantry{
    public Scout(String name){
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

    public abstract void explore();
}
