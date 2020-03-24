package edu.academy.visibility;

public class StaticMain {

    int a = 10;

    public static void main(String[] args) {
        StaticMain obj1 = new StaticMain();
        StaticMain obj2 = new StaticMain();
//        System.out.println(a);
        System.out.println(++obj1.a);
        System.out.println(obj2.a);
    }
}
