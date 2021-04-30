package com.zoo.animal;

import com.zoo.exception.*;

public class Goat extends Animal {
    public Goat() {
        super();
        this.roar = "Beeeeee";
        this.jumpHeight = 1.3;
    }

    public Goat(String Name, int Age) throws LongNameException, AgeException {
        super(Name, Age);
        this.roar = "Beeeeee";
        this.jumpHeight = 1.3;
    }

    public void lawn() { System.out.println(this.name + " is destroyed the lawn"); }

    public void horn() { System.out.println(this.name + " is butts horns"); }

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
