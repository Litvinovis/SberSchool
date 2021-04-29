package com.zoo.animal;

public class Dog extends Animal {
    public Dog() {
        super();
        this.roar = "woof woof";
        this.jumpHeight = 1.5;
    }

    public Dog(String Name, int Age) {
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
}
