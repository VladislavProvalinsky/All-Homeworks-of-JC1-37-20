package ClassTask_Homework6;

import java.util.*;

public class SortByValues {
    public static Map<String, Integer> sortByValue (Map <String, Integer> unsortedMap) {

        // 1. Конвертируем нашу Map в List объектов Map
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortedMap.entrySet());

        // 2.  Сортируем наш list  с помощью метода Collections.sort() используя в качестве параметра наш Comparator

        list.sort(new MapValuesComparator());

        // 3. Посещаем отсортированный list по значениям в новыую Map LinkedHashMap сохраняя порядок вставки.

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
