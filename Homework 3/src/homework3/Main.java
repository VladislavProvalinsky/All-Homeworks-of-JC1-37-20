package homework3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int [] arr = {4,8,7,3,3,3,3,4,4,2,2,7,8,9,4,4,4,4,0,0,0};
//        int [] arr1 = {0,1,2,3,4,5,6,7,8,9};
//        int [] arr2 = {0,1,2,3,4,5,6,7,8,0};
//        int [] arr3 = {0,1,2,3,5,5,5,7,8,0};
//        int [] arr4 = {1,1,1,1,1,1,1,1,1,0};
//        int [] arr5 = {7,9,4,5,3,2,0,6,1,8};
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество элементов вашего массива: ");
        int n = in.nextInt();
        int [] arr = new int [n];
        System.out.print("Введите элементы вашего массива: ");
        for (int i = 0; i < arr.length; i++) {
           arr[i] = in.nextInt();
        }
        ArraysSort ob = new ArraysSort();
        System.out.println("Ваш массив: "+ Arrays.toString(arr));
        ob.shakerSort(arr);
        System.out.println("Отсортированный массив: "+ Arrays.toString(arr));
        System.out.println("Массив без дубликатов: "+ Arrays.toString(ob.deleteDublicat(arr)));
    }
}
