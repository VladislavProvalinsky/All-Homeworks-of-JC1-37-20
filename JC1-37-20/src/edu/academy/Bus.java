package edu.academy;

public class Bus implements Movable {
    public void move (){
        System.out.println("Bus is moving");
    }
    public void beforeMove (){
        System.out.println("Не трамвай, объедит.");
    }
}
