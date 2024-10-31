package com.keyin6;

public class Main {
    public static void main(String[] args) {

        ShelterQueue shelter = new ShelterQueue(5);


        shelter.enqueue(new Dog("Waylon"));
        shelter.enqueue(new Cat("Georgie"));
        shelter.enqueue(new Dog("Chevy"));
        shelter.enqueue(new Cat("Steven"));
        shelter.enqueue(new Dog("Buddy"));

        shelter.printQueue();

        shelter.dequeueAny();
        shelter.dequeueCat();
        shelter.dequeueDog();

        shelter.printQueue();
    }
}


