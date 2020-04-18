package test.HashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Hash_Linked_TreeMaps {
    public static void main(String[] args) {
        Map <Integer, String> hashMap = new HashMap<>(); // внутри не гарантируется никакого порядка пар

        Map <Integer, String> linkedHashMap = new LinkedHashMap<>(); // в каком порядке добавили пары, в таком они и будут порядке выводиться

        Map <Integer, String> treeMap = new TreeMap<>(); // пары сортируются по ключу (естественный порядок сортировки по ключу)

        testMap(hashMap);
        testMap(linkedHashMap);
        testMap(treeMap);

    }
    public static void testMap (Map<Integer, String> map){
        map.put(39, "Bob");
        map.put(121, "Lewis");
        map.put(125, "Mike");
        map.put(77, "Vlad");
        map.put(4, "Tom");
        map.put(15, "Andy");

        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
