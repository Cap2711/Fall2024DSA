package com.keyin;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create a scanner for input
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.println("Enter the size of the array: ");
        int arr_size = 0;
        if (scanner.hasNextInt()) {
            arr_size = scanner.nextInt();
        }

        // Create array to store values
        double[] userNum = new double[arr_size];

        // For loop for all values to be inputted
        for (int i = 0; i < userNum.length; i++) {
            System.out.print("Enter a Temperature: ");
            userNum[i] = scanner.nextDouble();
        }

        scanner.close();

        // Call the getAvgTemp method and print the average
        double average = getAvgTemp(userNum);
        System.out.println("The average temperature is: " + average);

        // Print temperatures above average
        System.out.println("Temperatures above average are:");
        for (double temp : userNum) {
            if (temp > average) {
                System.out.println(temp);
            }
        }
    }

    // Calculate average temp with array
    public static double getAvgTemp(double[] temp) {
        double sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += temp[i];
        }
        return sum / temp.length;
    }
}

