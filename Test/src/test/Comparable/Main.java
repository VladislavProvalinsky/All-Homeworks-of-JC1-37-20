package test.Comparable;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Person> peopleList = new ArrayList<>();
        Set<Person> personSet = new TreeSet<>();

        AddElements(peopleList);
        AddElements(personSet);

        Collections.sort(peopleList);

        System.out.println(peopleList);
        System.out.println(personSet);
    }

    public static void AddElements (Collection collection){
        collection.add(new Person(1, "Danny"));
        collection.add(new Person(5, "Joe"));
        collection.add(new Person(3, "Ro"));
        collection.add(new Person(2, "Andrew"));
        collection.add(new Person(4, "Mike"));
    }
}

class Person implements Comparable<Person> {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.name.length() > o.getName().length()){
            return 1;
        } else if (this.name.length() < o.getName().length()){
            return -1;
        } else
            return 0;
    }
}