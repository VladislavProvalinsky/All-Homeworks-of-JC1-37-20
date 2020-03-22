package homework3;

public class MultTable {

//    2.1. Вывести таблицу умножения в консоль
    public void multTableSchool () {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

//    2.2. Перемножить числа от 1 до числа (включительно) введеннго через аргумент к исполняемой программе
    public int multTable (int x) {
        int num [] = new int [x+1];
        int mult = 1;
        for (int i = 1; i < num.length; i++) {
            num [i] = i;
            mult *= num [i];
        }
        return mult;
    }

//    2.3. Все цифры из числа введенного через аргумент к исполняемой программе перемножить между собой и вывести ход
//    вычислений в консоль
    public int multNumber (int x) {
        int res = 1;
        int count=0;
        while (x!=0){
            res *= x%10;
            x/=10;
            count ++;
            System.out.println("Multiplication "+count+" : "+res);
        }
        return res;
    }
}
