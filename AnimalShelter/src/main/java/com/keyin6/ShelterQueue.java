package com.keyin6;

public class ShelterQueue {
    private final int maxSize;
    private Node[] dogQueue;
    private Node[] catQueue;
    private int dogBeginningOfQueue, dogBackOfQueue, catBeginningOfQueue, catBackOfQueue;
    private int order;

    public ShelterQueue(int size) {
        this.maxSize = size;
        this.dogQueue = new Node[size];
        this.catQueue = new Node[size];
        this.dogBeginningOfQueue = -1;
        this.dogBackOfQueue = -1;
        this.catBeginningOfQueue = -1;
        this.catBackOfQueue = -1;
        this.order = 0;
    }

    private boolean isFull(Node[] queue, int backOfQueue) {
        return backOfQueue == maxSize - 1;
    }


    private boolean isEmpty(int beginningOfQueue, int backOfQueue) {
        return beginningOfQueue == -1 || beginningOfQueue > backOfQueue;
    }


    public void enqueue(Node animal) {
        animal.setOrder(order++);

        if (animal instanceof Dog) {
            if (isFull(dogQueue, dogBackOfQueue)) {
                System.out.println("Dog queue is full");
                return;
            }
            if (dogBeginningOfQueue == -1) dogBeginningOfQueue = 0;
            dogQueue[++dogBackOfQueue] = animal;
            System.out.println("Added Dog: " + animal.getName());
        } else if (animal instanceof Cat) {
            if (isFull(catQueue, catBackOfQueue)) {
                System.out.println("Cat queue is full");
                return;
            }
            if (catBeginningOfQueue == -1) catBeginningOfQueue = 0;
            catQueue[++catBackOfQueue] = animal;
            System.out.println("Added Cat: " + animal.getName());
        }
    }


    public Node dequeueAny() {
        if (isEmpty(dogBeginningOfQueue, dogBackOfQueue) && isEmpty(catBeginningOfQueue, catBackOfQueue)) {
            System.out.println("No animals in the shelter");
            return null;
        }

        Node oldestDog = isEmpty(dogBeginningOfQueue, dogBackOfQueue) ? null : dogQueue[dogBeginningOfQueue];
        Node oldestCat = isEmpty(catBeginningOfQueue, catBackOfQueue) ? null : catQueue[catBeginningOfQueue];

        if (oldestDog == null) return dequeueCat();
        if (oldestCat == null) return dequeueDog();

        return oldestDog.getOrder() < oldestCat.getOrder() ? dequeueDog() : dequeueCat();
    }


    public Node dequeueDog() {
        if (isEmpty(dogBeginningOfQueue, dogBackOfQueue)) {
            System.out.println("No dogs in the shelter");
            return null;
        }
        Node dog = dogQueue[dogBeginningOfQueue++];
        if (dogBeginningOfQueue > dogBackOfQueue) dogBeginningOfQueue = dogBackOfQueue = -1;
        System.out.println("Dequeued Dog: " + dog.getName());
        return dog;
    }


    public Node dequeueCat() {
        if (isEmpty(catBeginningOfQueue, catBackOfQueue)) {
            System.out.println("No cats in the shelter");
            return null;
        }
        Node cat = catQueue[catBeginningOfQueue++];
        if (catBeginningOfQueue > catBackOfQueue) catBeginningOfQueue = catBackOfQueue = -1;
        System.out.println("Dequeued Cat: " + cat.getName());
        return cat;
    }


    public void printQueue() {
        System.out.println("Current Shelter Queue:");

        System.out.println("Dogs:");
        for (int i = dogBeginningOfQueue; i <= dogBackOfQueue && i != -1; i++) {
            System.out.println(" - " + dogQueue[i].getName() + " (Order: " + dogQueue[i].getOrder() + ")");
        }

        System.out.println("Cats:");
        for (int i = catBeginningOfQueue; i <= catBackOfQueue && i != -1; i++) {
            System.out.println(" - " + catQueue[i].getName() + " (Order: " + catQueue[i].getOrder() + ")");
        }
    }
}
