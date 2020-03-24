package edu.academy.interfaces;

public class InterfacesMain3 {
    public static void main(String[] args) {
        Object movable = new Car();
        Car car = (Car) movable;
        car.move();
        car.beforeMove();
    }
}
