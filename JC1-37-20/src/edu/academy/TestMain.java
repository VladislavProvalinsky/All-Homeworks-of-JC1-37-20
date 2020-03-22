package edu.academy;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("Введите пожалуйста число 10");
        Scanner scanner = new Scanner(System.in);
        int i = 0, a = 0;
        do{
            a = scanner.nextInt();
            i++;
        } while(a!=10 && i<5);


    }
}
