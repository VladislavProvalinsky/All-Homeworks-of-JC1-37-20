package homework2;

public class CalculatorWithCounter implements ICalculator {

    private ICalculator calculator;
    private int counter;

    public CalculatorWithCounter(ICalculator calculator) {
        this.calculator = calculator;
    }

    public int getCounter() {
        return counter;
    }

    public double addition(double x1, double x2) {
        this.counter++;
        return calculator.addition(x1, x2);
    }

    public double minus(double x1, double x2) {
        this.counter++;
        return calculator.minus(x1, x2);
    }

    public double multiplication(double x1, double x2) {
        this.counter++;
        return calculator.multiplication(x1, x2);
    }

    public double division(double x1, double x2) {
        this.counter++;
        return calculator.division(x1, x2);
    }

    public double power(double x1, int power) {
        this.counter++;
        return calculator.power(x1, power);
    }

    public double module(double x) {
        this.counter++;
        return calculator.module(x);
    }

    public double sqrt(double x1) {
        this.counter++;
        return calculator.sqrt(x1);
    }
}
