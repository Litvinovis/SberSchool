package com.zoo.animal;

public class Cat extends Animal {
    public void Cat() {
        this.name = "Pushok";
        this.age = 2;
        this.roar = "meow meow";
        this.jumpHeight = 1.2;
    }

    public Cat(String Name, int Age) {
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
}
