package edu.academy.operator;

public class ShortOperatorsMain {
    public static void main(String[] args) {
        boolean result = print(1) || print(2);
        boolean result2 = print(3) | print(4);
    }

    public static boolean print(int a){
        System.out.println(a);
        return true;
    }
}
