package Homework6;

import java.util.*;

public class SortByValues {
    public static Map<String, Integer> sortByValue (Map <String, Integer> unsortedMap) {

        // 1. Конвертируем нашу Map в List объектов Map
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortedMap.entrySet());

        // 2. Сортируем наш list с помощью метода Collections.sort() используя в качестве параметра list и наш Comparator

        Collections.sort(list, new Comparator <Map.Entry<String, Integer>>(){

            // Реализуем необходимый метод интерфейса Comparator для сортировки нашей Map по значению.
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // 3. Помещаем отсортированный list по значениям в новую Map (LinkedHashMap) сохраняя порядок вставки.

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
