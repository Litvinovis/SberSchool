package com.zoo.animal;

import com.zoo.exception.*;
import java.util.concurrent.TimeUnit;

public class Rabbit extends Animal {
    public Rabbit() {
        super();
        this.roar = "Fur fur";
        this.jumpHeight = 1.9;
    }

    public Rabbit(String Name, int Age) throws LongNameException, AgeException  {
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

    public void voice() { System.out.println("Name: " + this.name + " Age: " + this.age + "say: " + this.roar); }

    public void jump() {
        System.out.println("Name: " + this.name + " Age: " + this.age + "is jumped " + this.jumpHeight + " meters up");
    }

    public void feed() {
        System.out.println("You tried to feed " + this.name + " but you have nothing in your arms, try take something");
    }

    public void feed(String food) {
        System.out.println("You feed " + this.name + " with " + food);
    }
}
