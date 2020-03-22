package edu.academy.animal;

public class Animal {
    public void eat(){
        System.out.println("Я питаюсь воздухом");
    }

    public void eat(String eat){
        System.out.println("Я питаюсь " + eat);
    }

    public void eat(int number){
        System.out.println("Я ботан и ем книги");
    }
}
