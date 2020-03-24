package edu.academy.interfaces;

public class InterfacesMain1 {
    public static void main(String[] args) {
        IMovable movable = new Bus();
        movable.move();
        movable.beforeMove();
    }
}
