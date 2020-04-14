package test.FileReader;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {
    public static void main(String[] args) {
        try {
            PrintWriter pw = new PrintWriter("Test1");
            pw.println("Hello world 1");
            pw.println("Hello world 2");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
