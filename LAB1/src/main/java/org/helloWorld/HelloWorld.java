package org.helloWorld;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Mrynskyi 18");
        int size = 19;
        double[] array = new double[size];
        for(int i = 0; i < size; i++) {
            array[i] = Math.random() * 100;
        }
        Arrays.sort(array);
        System.out.println("Array: ");
        for(double d: array) {
            System.out.printf("%6.2f",d);
        }
        System.out.println();

    }
}
