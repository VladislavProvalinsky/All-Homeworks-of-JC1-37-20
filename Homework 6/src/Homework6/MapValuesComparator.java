package Homework6;

import java.util.Comparator;
import java.util.Map;

public class MapValuesComparator implements Comparator <Map.Entry<String, Integer>> {

    // Реализуем необходимый метод интерфейса Comparator для сортировки нашей Map по значению.
    public int compare (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return (o1.getValue()).compareTo(o2.getValue());
    }
}
