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
        int chances = 3;
        while (chances > 0) {
            try {
                System.out.print("Введите число от 1 до 10: ");
                int number = Integer.parseInt(scanner.nextLine());
                chances--;
                if (number >= 0 && number <= 10) {
                    System.out.println("Вы ввели число: " + number);
                    return;
                } throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Число не из этого диапазона! Осталось попыток - " + chances);
            } catch (NumberFormatException e) {
                chances--;
                System.out.println("Текст не допустим! Осталось попыток - " + chances);
            }
        }
    }
}