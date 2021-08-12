package com.zoo;

import com.zoo.animal.*;

public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void space() {
        System.out.println('\n');
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println(GREEN + "Test for Animal class");
        Animal defaultAnimal = new Animal("Киса", 10);
        defaultAnimal.voice();
        defaultAnimal.setName("R2D2");
        defaultAnimal.setAge(22);
        defaultAnimal.voice();
        defaultAnimal.jump();
        space();

        System.out.println(YELLOW + "Test for Cat class");
        Cat cat = new Cat("Barsik", 3);
        cat.voice();
        cat.setAge(5);
        cat.setName("Musya");
        cat.voice();
        cat.jump();
        cat.MouseCatch();
        cat.VaseDrop();
        space();

        System.out.println(BLUE + "Test for Bear class");
        Bear bear = new Bear("Potapiych", 15);
        bear.voice();
        bear.setAge(12);
        bear.setName("Musya");
        bear.voice();
        bear.jump();
        bear.honey();
        bear.tree();
        space();

        System.out.println(PURPLE + "Test for Rabbit class");
        Rabbit rabbit = new Rabbit("Bunny", 1);
        rabbit.voice();
        rabbit.setAge(3);
        rabbit.setName("Roger");
        rabbit.voice();
        rabbit.jump();
        rabbit.carrot();
        rabbit.run();
        space();

        System.out.println(CYAN + "Test for Hedgehog class");
        Hedgehog hedgehog = new Hedgehog("Harry", 4);
        hedgehog.voice();
        hedgehog.setAge(7);
        hedgehog.setName("Luna");
        hedgehog.voice();
        hedgehog.jump();
        hedgehog.carry();
        hedgehog.touch();
        space();

        System.out.println(GREEN + "Test for Goat class");
        Goat goat = new Goat("Harley", 11);
        goat.voice();
        goat.setAge(5);
        goat.setName("Herbert");
        goat.voice();
        goat.jump();
        goat.horn();
        goat.lawn();
        space();

        System.out.println(YELLOW + "Test for Dog class");
        Dog dog = new Dog("Sharik", 17);
        dog.voice();
        dog.setAge(1);
        dog.setName("Persik");
        dog.voice();
        dog.jump();
        dog.stick();
        dog.tail();
        space();

        System.out.println(RESET + "End of tests");
    }
}
