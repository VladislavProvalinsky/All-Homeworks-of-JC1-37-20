package test.Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exception3 {
    public static void main(String[] args) {
//         Checked Exception (Compile time exception) = исключительные случаи в работе программы(java обязывает их обрабатывать)
        File file = new File("test");
        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//         Unchecked Exception (Runtime exception) = ошибки в работе программы(java не обязывает обрабатывать эти исключения)
        String str = null;
        str.length();
        int[] arr = new int[2];
        System.out.println(arr[2]);
    }
}
