package experimental;

public class Differentiation {

    public static double hValue(double x) {
        return Math.max(Math.abs(x / 1000.0), 0.0001);
     }

    public static double derivative(double x, Function f) {
        double h = hValue(x);
        return (f.evaluate(x + h) - f.evaluate(x - h)) / (2 * h);
    }

    public static double derivative(double x, Function f, double h, int n, int m) {
        double result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.pow(-1, i) * f.evaluate(x + (2 * i - n) * h) / factorial(i);
        }
        return result / Math.pow(2 * h, n) * Math.pow(x, m);
    }
    
    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    public static double extraDerivative(double x, Function f, double h, int n, int m) {
        double result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.pow(-1, i) * f.evaluate(x + (2 * i - n) * h) / factorial(i);
        }
        return result / Math.pow(2 * h, n) * Math.pow(x, m);
    }

}

