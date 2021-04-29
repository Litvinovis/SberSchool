package com.zoo.animal;

public class Bear extends Animal {
    public Bear() {
        super();
        this.roar = "AUUUURRRR";
        this.jumpHeight = 0.6;
    }

    public Bear(String Name, int Age) {
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

}
