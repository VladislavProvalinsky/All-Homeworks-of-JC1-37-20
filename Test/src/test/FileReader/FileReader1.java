package test.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader1 {
    public static void main(String[] args) {
        File file = new File("Test1");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
