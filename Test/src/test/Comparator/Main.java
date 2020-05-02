package test.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();

        animals.add("Cat");
        animals.add("Dog");
        animals.add("Frog");
        animals.add("Mouse");

        Collections.sort(animals, new StringLengthComparator());
        System.out.println(animals);


        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(34);
        numbers.add(9867);
        numbers.add(800);

        Collections.sort(numbers, new NumberComparator());
        System.out.println(numbers);

        List<Person> peoples = new ArrayList<>();

        peoples.add(new Person(1,"Danny"));
        peoples.add(new Person(4,"Bob"));
        peoples.add(new Person(2,"Rachel"));
        peoples.add(new Person(3,"Linda"));

        Collections.sort(peoples, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getId()>o2.getId()){
                    return 1;
                } else if (o1.getId()<o2.getId()){
                    return -1;
                } else
                    return 0;
            }
        });

        System.out.println(peoples);
    }
}

class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        if (o1.length()>o2.length()){
            return 1;
        } else if (o1.length()<o2.length()){
            return -1;
        } else
            return 0;
    }
}

class NumberComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2){
            return -1;
        } else if (o1 < o2){
            return 1;
        } else
            return 0;
    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
