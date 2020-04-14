package test.FileReader;

import java.io.*;
import java.util.Scanner;

public class FileReading {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;
        String path = "C:"+separator+"Users"+separator+"Vlad"+separator+"Desktop"+separator+"test.txt";//"C:\Users\Vlad\Desktop\test.txt"
        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
