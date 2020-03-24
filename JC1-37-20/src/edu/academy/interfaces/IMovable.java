package edu.academy.interfaces;

public interface IMovable {
    void move();

    default void beforeMove(){
        System.out.println("Ready to move");
    }
}
