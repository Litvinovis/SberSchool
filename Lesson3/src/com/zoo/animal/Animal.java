package com.zoo.animal;

public class Animal {

    protected String name;
    protected int age;
    protected String roar;
    protected double jumpHeight;

    public Animal() {
        this.name = "Bobik";
        this.age = 4;
        this.roar = "RRRRRRR";
        this.jumpHeight = 0.5;
    };

    public Animal(String Name, int Age) {
        this.name = Name;
        this.age = Age;
        this.roar = "RRRRRRR";
        this.jumpHeight = 0.5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void voice() {
        System.out.println( "Name: " + this.name + ", age: " + this.age + ", say: " + this.roar);
    }

    public void jump() {
        System.out.println( "Name: " + this.name + ", age: " + this.age + ", jumped " + this.jumpHeight + " meters up");
    }
}
