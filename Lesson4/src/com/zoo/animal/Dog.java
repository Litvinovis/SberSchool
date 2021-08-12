package com.zoo.animal;

import com.zoo.exception.*;

public class Dog extends Animal {
    public Dog() {
        super();
        this.roar = "woof woof";
        this.jumpHeight = 1.5;
    }

    public Dog(String Name, int Age) throws LongNameException, AgeException {
        super(Name, Age);
        this.roar = "woof woof";
        this.jumpHeight = 1.5;
    }

    public void tail () {
        System.out.println(this.name + " is wagging its tail");
    }

    public void stick () {
        System.out.println(this.name + " is brings you a stick");
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
