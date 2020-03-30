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

//        2.1. Сохранённый результат попробовать поделить на 0 (если возникнет ошибка закомментировать).
        double zeroDivision = result/0;
        System.out.println(zeroDivision); //функция y=1/x: при x стремящемся к 0 y - стремится к бесконечности =>
        // результат выражение равен бесконечности!

//        2.2. Далее сохранённый результат попробовать поделить на 0.0d  (если возникнет ошибка закомментировать).
//        https://habr.com/ru/post/219595/

        zeroDivision = result/0.0d;
        System.out.println(zeroDivision);

//        2.3. Создать интерфейс ICalculator, в котором будут объявлены все методы которые присутсвовали в нашем
//        калькуляторе CalculatorWithOperator. В CalculatorWithOperator заимплементить

//        2.4. Создать класс CalculatorWithMath. Изучить библиотеку (класс) Math из jdk.
//        (https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html)

//        2.5. В классе CalculatorWithMath должны присутствовать 4 метода (деления, умножение, вычитание, сложение)
//        данные методы можно скопировать из класса CalculatorWithOperator. В методах
//        (Возведение в степень, Модуль числа, Корень из числа) можно использовать только вызовы  методов библиотеки Math

        CalculatorWithMath number1 = new CalculatorWithMath();
        System.out.println(String.format("Функция модуля числа: %s, Функция степени числа: %s, Функция корня числа: %s",
                number1.module(-4.754), number1.power(4.14,-3),number1.sqrt(4.75)));

//        2.6. Повторить пункты 3-5 с классом CalculatorWithMath
//        Задание посложнее. Для того чтобы преступить к данному заданию необходимо выполнить все предыдущие.
    }
}
