//В отдельном классе, создать мэйн метод. Внутри данного метода создать экземпляр класса CalculatorWithOperator сохранив
//его в переменную. При помощи методов созданного объекта вичислить результат выражения 4.1 + 15 * 7 + (28 / 5) ^ 2.
//Результат записать в переменную (определить самый подходящий тип переменной).
//Вывести сохранённый результат в консоль.

package homework2;

public class CalculatorWithOperatorMain {
    public static void main(String[] args) {
        System.out.println("\"Добро пожаловать в калькулятор!\"");
        CalculatorWithOperator number = new CalculatorWithOperator();
        double division = number.division(28,5);
        double multiplication = number.multiplication(15,7);
        double power = number.power(division,2);
        double addition = number.addition(4.1,multiplication);
        double result = number.addition(addition,power);
        System.out.printf("Результат выражения равен: %5.2f%n",result);
    }
}
