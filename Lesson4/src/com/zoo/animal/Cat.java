package com.zoo.animal;

import com.zoo.exception.*;

public class Cat extends Animal {
    public void Cat() {
        this.name = "Pushok";
        this.age = 2;
        this.roar = "meow meow";
        this.jumpHeight = 1.2;
    }

    public Cat(String Name, int Age) throws LongNameException, AgeException {
        super(Name, Age);
        this.roar = "meow meow";
        this.jumpHeight = 1.2;
    }

    public void VaseDrop () {
        System.out.println("Oops " + this.name + " is dropped a vase from table");
    }

    public void MouseCatch() {
        System.out.println("Wow " + this.name + " is caught a mouse...computer mouse...");
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
