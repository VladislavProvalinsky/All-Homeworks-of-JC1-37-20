package test.ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainLinkedList {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();



        measureTime(linkedList); // используется цепочка узлов: head -> [1] -> [2] -> [3] -> [4] | head -> [5] -> [1] -> [2] -> [3] -> [4] (+ add в начало листа/remove; - add/get)
        measureTime(arrayList); // используется внутренний массив: [1][2][3][4][5] -> [6][1][2][3][4][5] -> [7][6][1][2][3][4][5] (+ add/get; - add в начало листа)
    }
    public static void measureTime (List<Integer> list){

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100_000; i++) {
            list.add(0,i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
