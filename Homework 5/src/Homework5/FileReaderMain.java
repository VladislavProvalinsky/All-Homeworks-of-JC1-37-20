//1. Найти в книге "Война и мир" https://www.dropbox.com/s/vmpxj6bsnflvgdi/%D0%B2%D0%BE%D0%B9%D0%BD%D0%B0%20%D0%B8%20%D0%BC%D0%B8%D1%80.txt?dl=0
//// (Прочитать https://howtodoinjava.com/java/io/java-read-file-to-string-examples/ и воспользоваться методом readAllBytesJava7 с этой страницы)
//// при помощи обычного поиска по строке.

package Homework5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderMain {
    private static String readAllBytesJava7(String filePath) {
        String text ="";
        try {
            text = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void main(String[] args) {
        String separator = File.separator;
        String path = "C:"+separator+"Users"+separator+"Vlad"+separator+"Desktop"+separator+"Война и мир.txt";
        EasySearch easySearch= new EasySearch();
        System.out.println(easySearch.search(readAllBytesJava7(path),"Война")); // 57
        System.out.println(easySearch.search(readAllBytesJava7(path)," и ")); // 13883
        System.out.println(easySearch.search(readAllBytesJava7(path),"мир")); // 298

    }
}
