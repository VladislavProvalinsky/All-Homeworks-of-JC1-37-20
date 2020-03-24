package homework3;

import java.util.Scanner;

public class ArraysCycles {
    Scanner in = new Scanner(System.in);

//    3.1 Вывести все элементы в консоль при помощи do....while, while, for, foreach. Элементы массива вводить
//    через консоль. Массив хранит в себе числа.
    public void doWhile (){
        System.out.print("Введите количество элементов массива: ");
        int n = in.nextInt();
        int arr [] = new int [n];
        System.out.print("Введите елементы вашего массива: ");
        int count = 0;
        do {
            arr [count] = in.nextInt();
            count ++;
        } while (count!=n);
        count =0;
        System.out.print("Ваш массив: ");
        do {
            System.out.print(arr[count] + " ");
            count ++;
        } while (count!=n);
    }

    public void while_ (){
        System.out.print("Введите количество элементов массива: ");
        int n = in.nextInt();
        int arr [] = new int [n];
        System.out.print("Введите елементы вашего массива: ");
        int count = 0;
        while (count!=n){
            arr [count] = in.nextInt();
            count ++;
        }
        count =0;
        System.out.print("Ваш массив: ");
        while (count!=n){
            System.out.print(arr[count] + " ");
            count ++;
        }
    }

    public void for_i (){
        System.out.print("Введите количество элементов массива: ");
        int n = in.nextInt();
        int arr [] = new int [n];
        System.out.print("Введите елементы вашего массива: ");
        for (int i = 0; i < arr.length; i++) {
            arr [i] = in.nextInt();
        }
        System.out.print("Ваш массив: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void for_each (){
        System.out.print("Введите количество элементов массива: ");
        int n = in.nextInt();
        int arr [] = new int [n];
        System.out.print("Введите елементы вашего массива: ");
        for (int i = 0; i < arr.length; i++) {
            arr [i] = in.nextInt();
        }
        System.out.print("Ваш массив: ");
        for (int item:arr) {
            System.out.print(item + " ");
        }
    }

// 3.2 Вывести каждый второй элемент массива
    public void every2Element (){
        System.out.print("Введите количество элементов массива: ");
        int n = in.nextInt();
        int arr [] = new int [n];
        System.out.print("Введите елементы вашего массива: ");
        for (int i = 0; i < arr.length; i++) {
            arr [i] = in.nextInt();
        }
        System.out.print("Каждый второй элемент массива: ");
        for (int i = 1; i < arr.length; i+=2) {
            System.out.print(arr[i] + " ");
        }
    }
}
