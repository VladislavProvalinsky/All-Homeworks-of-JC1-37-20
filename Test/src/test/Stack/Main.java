package test.Stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(3);
        stack.push(5);


        // Метод pop() - извлекает LIFO элемент из стэка и не оставляет его.
        // Метод peak() - показывает LIFO элемент в стэке, оставляя его на месте

//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        while (!stack.empty()){
            System.out.println(stack.pop());
        }



    }
}
