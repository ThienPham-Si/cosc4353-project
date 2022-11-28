package experimental;

public class Function {
    
        public static double evaluate(double x) {
            return Math.pow(x, 3) - 2 * Math.pow(x, 2) + 3 * x - 4;
        }
    
        public static double evaluate(double x, int n, int m) {
            double result = 0;
            for (int i = 0; i < n; i++) {
                result += Math.pow(-1, i) * Math.pow(x, n - i) / factorial(i);
            }
            return result * Math.pow(x, m);
        }
    
        public static double factorial(int n) {
            if (n == 0) {
                return 1;
            }
            return n * factorial(n - 1);
        }


    
}

