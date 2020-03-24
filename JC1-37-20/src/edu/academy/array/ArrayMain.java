package edu.academy.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayMain {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);
        }
        System.out.println("initial array:" + Arrays.toString(array));

        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + 10);
        }
        System.out.println("new array:" + Arrays.toString(array));

    }
}
