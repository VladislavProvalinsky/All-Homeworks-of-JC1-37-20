package homework2;

public class CalculatorWithCounterMain {
    public static void main(String[] args) {
        System.out.println("\"Добро пожаловать в калькулятор!\"");
        ICalculator calculator = new CalculatorWithOperator();
        CalculatorWithCounter calc = new CalculatorWithCounter(calculator);
        double division = calc.division(28, 5);
        double multiplication = calc.multiplication(15, 7);
        double power = calc.power(division, 2);
        double addition = calc.addition(4.1, multiplication);
        double result = calc.addition(addition, power);
        System.out.printf("Результат выражения равен: %5.2f%n", result);
        System.out.println("Колличество вызванных методов: "+calc.getCounter());
    }
}
