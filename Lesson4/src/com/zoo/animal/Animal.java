package com.zoo.animal;

import com.zoo.exception.*;

abstract public class Animal implements Voice, Jump {

    protected String name;
    protected int age;
    protected String roar;
    protected double jumpHeight;

    public Animal() {
        this.name = "default";
        this.age = 10;
        this.jumpHeight = 0.2;
        this.roar = "RRRRRRRR";
    }

    public Animal(String Name, int Age) throws LongNameException, AgeException {
        if(Age <= 0) {
            throw new AgeException("Age lower than 1");
        }
        else if (Age > 99) {
            throw new AgeException("Age higher than 99");
        }
        if(Name.length() > 15) {
            throw new LongNameException("Name is too long");
        }
        this.name = Name;
        this.age = Age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws LongNameException {
        if (name.length() > 15) {
            throw new LongNameException("Name is too long");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int Age) throws AgeException {
        if(Age <= 0) {
            throw new AgeException("Age lower than 1");
        }
        else if (Age > 99) {
            throw new AgeException("Age higher than 99");
        }
        this.age = Age;
    }

    abstract public void feed();
    abstract public void feed(String food);
}
