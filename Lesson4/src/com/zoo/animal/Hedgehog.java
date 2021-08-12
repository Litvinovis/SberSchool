package com.zoo.animal;

import com.zoo.exception.*;

public class Hedgehog extends Animal {
    public Hedgehog() {
        super();
        this.roar = "hur hur";
        this.jumpHeight = 0.1;
    }

    public Hedgehog(String Name, int Age) throws LongNameException, AgeException {
        super(Name, Age);
        this.roar = "hur hur";
        this.jumpHeight = 0.1;
    }

    public void carry() {
        System.out.println(this.name + " is takes food to the burrow");
    }

    public void touch() {
        System.out.println(this.name + " is bites your finger, never try to touch a Hedgehog");
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
