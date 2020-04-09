package test.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReading {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;
        String path = "C:"+separator+"Users"+separator+"Vlad"+separator+"Desktop"+separator+"test.txt";//"C:\Users\Vlad\Desktop\test.txt"
        System.out.println(path);
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
