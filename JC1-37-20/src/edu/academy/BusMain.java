package edu.academy;

public class BusMain {
    public static void main(String[] args) {
        Movable movable = new Car();
        movable.beforeMove();
        movable.move();
    }
}
