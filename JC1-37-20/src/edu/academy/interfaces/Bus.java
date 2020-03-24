package edu.academy.interfaces;

public class Bus implements IMovable {

    @Override
    public void move() {
        System.out.println("move");
    }

    public void beforeMove(){
        System.out.println("Не трамвай объедит");
    }
}
