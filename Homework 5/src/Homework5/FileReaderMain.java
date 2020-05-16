//1. Найти в книге "Война и мир" https://www.dropbox.com/s/vmpxj6bsnflvgdi/%D0%B2%D0%BE%D0%B9%D0%BD%D0%B0%20%D0%B8%20%D0%BC%D0%B8%D1%80.txt?dl=0
//// (Прочитать https://howtodoinjava.com/java/io/java-read-file-to-string-examples/ и воспользоваться методом readAllBytesJava7 с этой страницы)
//// при помощи обычного поиска по строке.

package Homework5;

import java.io.File;
import java.util.regex.Pattern;

public class FileReaderMain {
    public static void main(String[] args) {
        String separator = File.separator;
        String path = "C:"+separator+"Users"+separator+"Vlad"+separator+"Desktop"+separator+"Война и мир.txt";
        //ищем слова с помощью паттерна
        Pattern pattern1 = Pattern.compile("[Вв]ойна");
        Pattern pattern2 = Pattern.compile("[Мм]ир");
        Pattern pattern3= Pattern.compile(" [Ии] ");
        System.out.println(EasySearchRegex.searchWithPattern(pattern1, ReadAllBytes.readAllBytesJava7(path)));
        System.out.println(EasySearchRegex.searchWithPattern(pattern2, ReadAllBytes.readAllBytesJava7(path)));
        System.out.println(EasySearchRegex.searchWithPattern(pattern3, ReadAllBytes.readAllBytesJava7(path)));

//        EasySearch easySearch= new EasySearch();
//        System.out.println(easySearch.search(ReadAllBytes.readAllBytesJava7(path),"Война")); // 57
//        System.out.println(easySearch.search(ReadAllBytes.readAllBytesJava7(path)," и ")); // 13883
//        System.out.println(easySearch.search(ReadAllBytes.readAllBytesJava7(path),"мир")); // 298

    }
}
