package com.zoo;

import com.zoo.animal.*;
import com.zoo.exception.*;

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

    public static void main(String[] args) throws InterruptedException, LongNameException, AgeException, AviaryException {

        System.out.println(YELLOW + "Test for Cat class");
        Cat cat = new Cat("Barsik", 3);
        cat.voice();
        cat.jump();
        cat.MouseCatch();
        cat.VaseDrop();
        space();

        System.out.println(BLUE + "Test for Bear class");
        Bear bear = new Bear("Potapiych", 15);
        bear.voice();
        bear.jump();
        bear.honey();
        bear.tree();
        space();

        System.out.println(PURPLE + "Test for Rabbit class");
        Rabbit rabbit = new Rabbit("Bunny", 1);
        rabbit.voice();
        rabbit.jump();
        rabbit.carrot();
        rabbit.run();
        space();

        System.out.println(CYAN + "Test for Hedgehog class");
        Hedgehog hedgehog = new Hedgehog("Harry", 4);
        hedgehog.voice();
        hedgehog.jump();
        hedgehog.carry();
        hedgehog.touch();
        space();

        System.out.println(GREEN + "Test for Goat class");
        Goat goat = new Goat("Harley", 11);
        goat.voice();
        goat.jump();
        goat.horn();
        goat.lawn();
        space();

        System.out.println(YELLOW + "Test for Dog class");
        Dog dog = new Dog("Sharik", 17);
        dog.voice();
        dog.jump();
        dog.stick();
        dog.tail();
        space();

        System.out.println(BLUE + "Test for aviary");

        Aviary aviary = new Aviary("Wild", 4);
        aviary.animalAdd(goat);
        aviary.animalAdd(rabbit);
        aviary.animalAdd(bear);
        aviary.animalAdd(hedgehog);

        aviary.animalRemove(rabbit);

        Aviary aviary2 = new Aviary("Pet", 4);
        aviary2.animalAdd(dog);
        aviary2.animalAdd(rabbit);
        aviary2.animalAdd(cat);


        System.out.println(PURPLE + "Exception tests");

        System.out.println("Age exception test");
//        dog.setAge(0);
//        Dog dog2 = new Dog("NewDog", -10);
        System.out.println("Name exception test");
//        Cat cat2 = new Cat("NewCatWithLongLongLOngName", 10);
//        dog.setName("LongLongLongVeryLongName");
        System.out.println("Aviary exception test");

//        Dog BigDog = new Dog("Big", 15);
//        aviary2.animalAdd(BigDog);                  //test for two obj the same class in one aviary

//        Cat TestCat = new Cat("Kisa", 44);
//        Rabbit TestRabbit = new Rabbit("Test", 22);
//        aviary.animalAdd(TestCat);
//        aviary.animalAdd(TestRabbit);               //aviary overflow test

//        aviary2.animalRemove(bear);                 //test for removing not existing animal in this aviary

//        aviary2.animalAdd(dog);                     //test for already added animal

        System.out.println(RESET + "End of tests");
    }
}
