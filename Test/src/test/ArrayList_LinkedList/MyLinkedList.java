package test.ArrayList_LinkedList;

import java.util.Arrays;

public class MyLinkedList {

    private Node head; // значение главного узла
    private int size;

    public void add(int value) {
        // если это первое добавление в список
        if (head == null) {
            // то здесь будет какая-то логика
            this.head = new Node(value); // создаем главный узел со значением в нем
        } else {
            Node temp = head;
            while (temp.getNext()!= null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    public int get (int index){
        int currentIndex = 0;
        Node result = head;
        while (result != null){
            if (currentIndex==index){
                return result.getValue();
            } else {
                result = result.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    public void remove (int index){
        if (index == 0){
            head = head.getNext();
            size--;
            return;
        }
        int currentIndex = 0;
        Node temp = head;
        while (temp != null){
            if (currentIndex == index-1){
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public String toString (){
        int [] result = new int [size];

        int idx = 0;
        Node temp = head;

        while (temp != null){
            result[idx++] = temp.getValue();
            temp = temp.getNext();

        }
        return Arrays.toString(result);
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
}
