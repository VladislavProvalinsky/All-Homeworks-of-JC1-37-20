package edu.academy.operator;

public class IfOperatorMain {
    public static void main(String[] args) {
        int a = 10;
        int b = 9;

        int x;

        if (a < b){
            //true
            x = b - a;
        } else {
            //false
            x = a - b;
        }

        System.out.println(x);

        if (x > 1 && x < 1){
            //true
            x = b - a;
        } else {
            //false
            x = a - b;
        }

        //                         true    false
        System.out.println(a < b ? b - a : a - b);
    }
}
