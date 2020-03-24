package edu.academy.interfaces;

import edu.academy.Man;

public class Car extends Bus implements IMovable {
    @Override
    public void move() {
        System.out.println("В бесконечность и далее");
    }
}
