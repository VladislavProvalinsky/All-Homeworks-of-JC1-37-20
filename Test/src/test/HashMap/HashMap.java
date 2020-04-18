package test.HashMap;

import java.util.Map;

public class HashMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new java.util.HashMap<>(); // использовать HashMap можно если нам не важен порядок в котором
        // помещаются пары ключ-значение. Т.к при выводе всех пар, они выводятся в рандомной последовательности и
        // такая особенность зависит от хеширования пар. Если порядок нам важен - надо использовать другие классы Map (LinkedHashMap / TreeMap).
        map.put(1,"Единица");
        map.put(2,"Двойка");
        map.put(3, "Тройка");

//        System.out.println(map);
//
//        map.put(3,"Другое значение длz ключа 3");
//        System.out.println(map);
//
//        System.out.println(map.get(1));
//        System.out.println(map.get(10));

        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
