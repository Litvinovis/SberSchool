package com.zoo.animal;

public class Hedgehog extends Animal {
    public Hedgehog() {
        super();
        this.roar = "hur hur";
        this.jumpHeight = 0.1;
    }

    public Hedgehog(String Name, int Age) {
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
}
