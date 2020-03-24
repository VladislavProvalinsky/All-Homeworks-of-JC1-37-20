package homework3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MultTable ob = new MultTable();
        ArraysCycles ob1 = new ArraysCycles();
        ArraysSort ob2 = new ArraysSort();
//        System.out.println("Result: "+ ob.multTable(7));
//        ob.multNumber(155547);
//        ob1.every2Element();
        int [] arr1 = {0,1,2,3,4,5,6,7,8,9};
        int [] arr2 = {0,1,2,3,4,5,6,7,8,0};
        int [] arr3 = {0,1,2,3,5,5,5,7,8,0};
        int [] arr4 = {1,1,1,1,1,1,1,1,1,0};
        System.out.println(Arrays.toString(arr3));
        ob2.quickSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
