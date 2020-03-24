package edu.academy;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WhileMain {
    public static void main(String[] args) {
        int [] array = new int [10];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i]= rand.nextInt(10);

        }
        System.out.println("initial array");
        System.out.println(Arrays.toString(array));
        System.out.println("new array:");
        for (int i = 0; i < array.length; i++) {
            array[i]+=10;
        }
        System.out.println(Arrays.toString(array));
    }
}


//        for (int i = 0; i < 1000; i++) {
//            if (i % 300 == 0)
//                break;
//                System.out.println("ghb");
//        int i =17;
//        while (i<=28){
//            if (i%13==0){
//                break;
//            }
//            i++;
//        }
//        System.out.println("First number is : "+i);
//    }
//}

//        Scanner in = new Scanner(System.in);
//        System.out.print("Введите число 10: ");
//        int i = 0, a = 0;
//        do {
//            a = in.nextInt();
//            i++;
//        } while (i == 10 && i < 5);


////        while (i<5){
////            System.out.println("i = "+i);
////            i++;
////        }
//        int n = 5;
//        do {
//            System.out.println("Sample : "+n);
//            n--;
//        } while (n>0);


