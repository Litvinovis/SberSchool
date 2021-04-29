package com.zoo.animal;

public class Goat extends Animal {
    public Goat() {
        super();
        this.roar = "Beeeeee";
        this.jumpHeight = 1.3;
    }

    public Goat(String Name, int Age) {
        super(Name, Age);
        this.roar = "Beeeeee";
        this.jumpHeight = 1.3;
    }

    public void lawn() {
        System.out.println(this.name + " is destroyed the lawn");
    }

    public void horn() {
        System.out.println(this.name + " is butts horns");
    }
}
