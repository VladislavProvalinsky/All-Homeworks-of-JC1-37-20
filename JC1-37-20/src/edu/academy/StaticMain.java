package edu.academy;

public class StaticMain {
    static final int NUMBER_PI = 10;


    public static void main(String[] args) {
        StaticMain obj1 = new StaticMain();
        StaticMain obj2 = new StaticMain();
        System.out.println(obj1.NUMBER_PI);
        System.out.println(obj2.NUMBER_PI);
    }


}
