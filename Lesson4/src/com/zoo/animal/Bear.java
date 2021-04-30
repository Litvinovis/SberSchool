package com.zoo.animal;

import com.zoo.exception.*;

public class Bear extends Animal {
    public Bear() {
        super();
        this.roar = "AUUUURRRR";
        this.jumpHeight = 0.6;
    }

    public Bear(String Name, int Age) throws LongNameException, AgeException {
        super(Name, Age);
        this.roar = "AUUUURRRR";
        this.jumpHeight = 0.6;
    }

    public void honey() {
        System.out.println(this.name + " is eating honey");
    }

    public void tree() {
        System.out.println(this.name + " is climbing on a tree");
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
