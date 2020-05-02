package test.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(4);
        list.add(7);
        list.add(9);
        list.add(17);

        Iterator<Integer> itr = list.iterator();

        int count = 0;
        // До Java 5
        while (itr.hasNext()){
            System.out.println(itr.next());
            if (count == 1){
                itr.remove();
            }
            count++;
        }
        System.out.println(list);

        // Java 5
        // уикл foreach не позволяет удалять элементы из списка в отличие от итератора, тк этот цикл более абстрактный и служит для перебора
        for (Integer integer : list){
            System.out.println(integer);
        }
    }
}
