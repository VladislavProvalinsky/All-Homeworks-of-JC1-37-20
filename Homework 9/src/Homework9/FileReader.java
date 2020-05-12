package Homework9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    // пишем статический метод считывания файла по байтам
    public static String readAllBytesJava7 (String filePath) {
        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
