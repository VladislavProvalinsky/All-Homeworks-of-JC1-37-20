package test.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Hash_LikedHash_TreeSet { // классы интерфейса Set позволяют хранить только уникальные значения элементов. Повторения/дубликаты не допустимы.
    public static void main(String[] args) {
//        Set<String> hashSet = new HashSet<>(); // внутри не гарантируется никакого порядка эл-в
//        Set<String> linkedHashSet = new LinkedHashSet<>(); // в каком порядке добавили элементы, в таком они и будут порядке выводиться
//        Set<String> treeSet = new TreeSet<>(); // элементы сортируются по их естественному (лексико-графическому) порядку

//        hashSet.add("Donald");
//        hashSet.add("Mike");
//        hashSet.add("Lara");
//        hashSet.add("Katy");
//        hashSet.add("Ann");
//
//        System.out.println(hashSet.contains("Mike")); // метод contains во множествах Set работает очень быстро, из-за хеширования
//        System.out.println(hashSet.isEmpty());

        // union - объединение
        Set<Integer> set1 = new HashSet<>();
        set1.add(0);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();

        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);

        // union - объединение множеств
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println(union);
        // intersection - пересечение множества
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println(intersection);
        // difference - разность множеств
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println(difference);
    }
}
