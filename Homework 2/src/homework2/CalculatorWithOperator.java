package homework2;

public class CalculatorWithOperator {

    public double addition(double x1, double x2) {
        double res;
        res = x1 + x2;
        return res;
    }

    public double minus(double x1, double x2) {
        double res;
        res = x1 - x2;
        return res;
    }

    public double multiplication(double x1, double x2) {
        double res;
        res = x1 * x2;
        return res;
    }

    public double division(double x1, double x2) {
        double res;
        res = x1 / x2;
        return res;
    }

    public double power(double x1, int power) {
        double res = x1;
        for (int i = 0; i < power - 1; i++) {
            res *= x1;
        }
        return res;
    }

    public double module(double x) {
        double res;
        if (x < 0)
            res = -x;
        else
            res = x;
        return res;
    }

    public double sqrt(double x1, int sqrt_power) {
        double sqrt = 0;
        if (x1 < 0 && sqrt_power % 2 == 0) {
            System.out.println("Корня четной степени из отрицательного числа не существует!");
            System.exit(0);
        } else {
            double t;
            double squareRoot = x1 / sqrt_power;
            int n = 1;
            do {
                t = squareRoot;
                double res = 1;
                for (int j = sqrt_power - n; j > 0; j--) {
                    res *= t;
                }
                t = squareRoot;
                squareRoot = ((sqrt_power - 1) * t + (x1 / res)) / sqrt_power;
            } while (t - squareRoot != 0);
            sqrt += squareRoot;
            return squareRoot;
        }
        return sqrt;
    }
}