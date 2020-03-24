package edu.academy;

public class IfOperatorMain {
    public static void main(String[] args) {
        int x = 5;
        int y = 7;
        if (x==5){
            y=9;
        }
        else if (y==9){
            x=3;
        }
        System.out.println(x +" "+ y);
    }
}
