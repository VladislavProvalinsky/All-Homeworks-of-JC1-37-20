package test.ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainArrayList {
    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal(1,"Ship"));
        list.add(new Animal(2,"Cat"));
        list.add(new Animal(3, "Dog"));
        System.out.println(list);
        List<Animal>list1 = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            list1.add(list.set(i, list.get(i)));
        }
        System.out.println(list1);
    }
}