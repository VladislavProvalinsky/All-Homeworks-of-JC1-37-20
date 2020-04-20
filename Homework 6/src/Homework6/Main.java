package Homework6;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String separator = File.separator;
        String path = "C:" + separator + "Users" + separator + "Vlad" + separator + "Desktop" + separator + "Война и мир.txt";
        String text = ReadAllBytes.readAllBytesJava7(path);
        String [] text1 = text.toLowerCase().replaceAll("\\,|\\.|\\!|\\?|\\\"|\\:|\\--|\\-|\\;|\\(|\\)","").split("\\s|\\b");

        List<String> testList = new ArrayList<>(Arrays.asList(text1));
        testList.removeIf(str -> str.equals(""));

        Map<String, Integer> map = new HashMap<>();

        for (String word : testList) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else {
                map.put(word, 1);
            }
        }

        Map<String, Integer> sortedMap = SortByValues.sortByValue(map);

//        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()){
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        // 10 часто встречающихся слов в книге
        List<Map.Entry<String, Integer>> list = new ArrayList<>(sortedMap.entrySet());
        System.out.println("10 часто встречающихся слов в книге:");
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i));
        }
    }
}
