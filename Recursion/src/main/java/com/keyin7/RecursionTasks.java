package com.keyin7;

public class RecursionTasks {

   // #1
    public int sumingPos(int n) {
        if (n < 10) return n;
        return (n % 10) + sumingPos(n / 10);
    }

   // #2
    public String convertToBinary(int n) {
        if (n <= 1) return Integer.toString(n);
        return convertToBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        RecursionTasks tasks = new RecursionTasks();

        //Use#1
        System.out.println("Sum of digits in 10: " + tasks.sumingPos(10));
        System.out.println("Sum of digits in 123: " + tasks.sumingPos(123));
        System.out.println("Sum of digits in 9876: " + tasks.sumingPos(9876));

        //Use #2
        System.out.println("Binary of 10: " + tasks.convertToBinary(10));
        System.out.println("Binary of 42: " + tasks.convertToBinary(42));
        System.out.println("Binary of 100: " + tasks.convertToBinary(100));
    }
}
