//ДЗ6:
//        Написать код который у пользователя через консоль попросит ввести число от 1 до 10 и напечатать его в консоль.
//        В случае если пользователь введёт число не из этого диапазона вывести сообщение что нужно повторить попытку.
//        Всего у пользователя 3 попытки ввести верное число. Предусмотреть возможность того что пользователь введёт не
//        число а какой-то текст. В этом случае необходимо выдать сообщение что текст не допустим и предоставить новую попытку.

package Homework7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int chances = 3;
        while (counter < 3) {
            System.out.print("Введите число от 1 до 10: ");
            try {
                int number = scanner.nextInt();
                if (number >=0 && number <=10) {
                    System.out.println("Вы ввели число: " + number);
                    return;
                } else if (chances==1){
                    System.out.println("Вы рукожоп!");
                    return;
                } else {
                    counter++;
                    chances--;
                    System.out.println("Число не из этого диапазона! Повторите попытку.");
                    System.out.printf("(Осталось попыток %d) ", chances);
                }
            } catch (InputMismatchException e){
                if (chances==1) {
                    System.out.println("Вы рукожоп!");
                    return;
                } else {
                    counter++;
                    chances--;
                    System.out.println("Текст не допустим! Повторите попытку.");
                    System.out.printf("(Осталось попыток: %d) ", chances);
                    scanner.next();
                }
            }
        }
    }
}
