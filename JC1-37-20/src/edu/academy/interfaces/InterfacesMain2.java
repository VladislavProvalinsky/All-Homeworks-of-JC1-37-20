package edu.academy.interfaces;

public class InterfacesMain2 {
    public static void main(String[] args) {
        Object movable = new Car();

        ((Car) movable).beforeMove();
        ((Car) movable).move();
        movable.toString();

    }
}
