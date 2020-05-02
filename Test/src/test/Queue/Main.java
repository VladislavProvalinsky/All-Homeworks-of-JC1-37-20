package test.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

//        Queue<Person> people = new LinkedList<>();

        Queue<Person> people = new ArrayBlockingQueue<>(3);

        /*
        Методы: offer(), poll(), peak() если возникает ошибка возвращают специальное значение
        Методы: add(), remove(), element() если возникает ошибка выбрасывают исключение
         */

        System.out.println(people.offer(person3));
        System.out.println(people.offer(person2));
        System.out.println(people.offer(person4));
        System.out.println(people.offer(person1));

//        people.add(person3);
//        people.add(person2);
//        people.add(person4);
//        people.add(person1);

        // person3 <- person2 <- person4 <- person1

//        for(Person person : people){
//            System.out.println(person);
//        }

//        System.out.println(people.remove()); // удаляет первый элемент в очереди
//        System.out.println(people.peek()); // показывает первый элемент в очереди, но не удаляет его
//        System.out.println(people);
    }
}

class Person {
    private int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}