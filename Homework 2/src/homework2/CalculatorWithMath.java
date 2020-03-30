package homework2;

public class CalculatorWithMath extends CalculatorWithOperator implements ICalculator {

    public double addition(double x1, double x2) {
        return super.addition(x1, x2);
    }

    public double minus(double x1, double x2) {
        return super.minus(x1, x2);
    }

    public double multiplication(double x1, double x2) {
        return super.multiplication(x1, x2);
    }

    public double division(double x1, double x2) {
        return super.division(x1, x2);
    }

    public double power(double x1, int power) {
        return Math.pow(x1,power);
    }

    public double module(double x) {
        return Math.abs(x);
    }

    public double sqrt(double x1) {
        return Math.sqrt(x1);
    }
}
