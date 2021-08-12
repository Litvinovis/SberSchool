package com.zoo.animal;

import java.util.concurrent.TimeUnit;

public class Rabbit extends Animal {
    public Rabbit() {
        super();
        this.roar = "Fur fur";
        this.jumpHeight = 1.9;
    }

    public Rabbit(String Name, int Age) {
        super(Name, Age);
        this.roar = "Fur fur";
        this.jumpHeight = 1.9;
    }

    public void carrot() throws InterruptedException {
        System.out.println(this.name + " starting to find a carrot");
        try {
            TimeUnit.SECONDS.sleep(3);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        System.out.println(this.name + " is founded a carrot");
    }

    public void run() {
        System.out.println(this.name + " is ran away");
    }
}
