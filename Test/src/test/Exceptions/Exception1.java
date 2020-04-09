package test.Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exception1 {
    public static void main(String[] args) {
        File file = new File("jrdkjdfkl");
        try {
            Scanner scanner = new Scanner (file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }


        try {
            fileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

    }

    public static void fileReader (File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
