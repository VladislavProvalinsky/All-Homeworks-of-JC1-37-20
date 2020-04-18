package test.ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MainArrayList {
    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal(1,"Ship"));
        list.add(new Animal(2,"Cat"));
        list.add(new Animal(3, "Dog"));
        System.out.println(list);
        List<Animal>list1 = new LinkedList<>(list);
        System.out.println(list1);
        list1.add(new Animal(4, "Mouse"));
        System.out.println(list1.get(0));
        System.out.println(list1.size());
        for (Animal animal: list1) {
            System.out.println(animal);
        }
        list1.remove(3);
        System.out.println(list1);

    }
}