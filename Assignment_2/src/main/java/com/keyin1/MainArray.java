package com.keyin1;

public class MainArray {
    // Array declaration
    int arr[] = null;

    // Constructor for setting the array size
    public MainArray(int sizeOfArray) {
        arr = new int[sizeOfArray];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

    // Insert method
    public void insert(int valueToInsert, int index) {
        try {
            if (arr[index] == Integer.MIN_VALUE) {
                arr[index] = valueToInsert;
                System.out.println("Successfully Inserted into array at index " + index);
            } else {
                System.out.println("This space is already occupied at index " + index);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Index");
        }
    }

    // Traverse method
    public void traverse() {
        System.out.print("[ ");
        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        } catch (Exception e) {
            System.out.println("Array no longer exists");
        }
        System.out.println("]");
    }

    // Delete value at a specific index
    public void deleteValueAtIndex(int index) {
        try {
            arr[index] = Integer.MIN_VALUE;
            System.out.println("Value at index " + index + " has been deleted.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Index");
        }
    }

    // Main method
    public static void main(String[] args) {

        MainArray mainArray = new MainArray(6);

        // Inserting values
        mainArray.insert(3, 0);
        mainArray.insert(4, 1);
        mainArray.insert(6, 2);
        mainArray.insert(1, 3);
        mainArray.insert(2, 4);
        mainArray.insert(8, 5);

        // Traverse
        mainArray.traverse();

        // Delete a value at an index
        mainArray.deleteValueAtIndex(3);

        // Traverse again to show change
        mainArray.traverse();
    }
}

