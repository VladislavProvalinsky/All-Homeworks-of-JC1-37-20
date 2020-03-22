package edu.academy.animal;

public class EatMain {
    public static void main(String[] args) {
        Animal rabbit = new Animal();
        Fizik fizik = new Fizik();

        rabbit.eat();
        rabbit.eat("Морква");
        rabbit.eat(10);
        System.out.println("+++++++++++");
        fizik.eat();
        fizik.eat("Морква");
        fizik.eat(10);
    }
}
