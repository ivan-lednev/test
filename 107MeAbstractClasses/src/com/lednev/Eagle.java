package com.lednev;

public class Eagle extends Scout {

    public Eagle(String name) {
        super(name);
    }

    @Override
    public void explore() {
        System.out.println("Eagle > " + this.getName() + " > explore()");
    }
}
