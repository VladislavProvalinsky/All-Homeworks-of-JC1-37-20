package test.HashCode_Equals;

import java.util.*;

public class HashCode_Equals {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();

        map.put(new Person(1, "Mike"),"Mike");
        map.put(new Person(1,"Mike"), "Katy");

        set.add(new Person(1,"Mike"));
        set.add(new Person(1,"Mike"));

        System.out.println(map);
        System.out.println(set);
    }
}
class Person {

    /*
    Контракт hashCode() - equals():
        Сначала запускается метод hashCode()
        1) если хеши разные -> то объекты разные
        2) если хеши одинаковые ->
            - объекты одинаковые;
            - объекты разные(коллизия) -> запускается метод equals() -> equals() дает ответ
     */

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // медленный способ проверки сравнения, тк сравнивается содержимое объектов класса.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    // {object} -> {int} т.е. при запуске метода hashcode все объекты конвертируются в целые числа и сравниваются тк это самый быстрый способ сравнения
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
}
