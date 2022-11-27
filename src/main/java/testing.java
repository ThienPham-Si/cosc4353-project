import simplification.*;

import java.util.Arrays;
import java.util.Scanner;

public class testing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Enter the expression");
        String exp = sc.next();

        // example: 2x, +, 3x
        exp = exp.replaceAll("\\s", "");
        String[] operators = exp.split("(?<=[-+*/])|(?=[-+*/])");
        Mult[] binaryExpressions = new Mult[operators.length];
        for (int i = 0; i < operators.length; i++) {
            if(i%2==0){
                String[] part = operators[i].split("(?<=\\d)(?=\\D)");
                int coeff = Integer.parseInt(part[0]);
                String var = part[1];
                binaryExpressions[i] = new Mult(coeff, var);
            }else{
                operators[i] = operators[i];
            }
        }

        switch ((operators[1])){
            case "+":
                System.out.println(new Plus((Mult)binaryExpressions[0], (Mult)binaryExpressions[2]).advancedSimplify());
                break;
            case "-":
                System.out.println(new Minus((Mult)binaryExpressions[0], (Mult)binaryExpressions[2]).advancedSimplify());
                break;
            case "*":
                System.out.println(new Mult((Mult)binaryExpressions[0], (Mult)binaryExpressions[2]).advancedSimplify());
                break;
            case "/":
                System.out.println(new Div((Mult)binaryExpressions[0], (Mult)binaryExpressions[2]).advancedSimplify());
                break;
            default:
                break;
        }

    }
//System.out.println("Plus simplify examples:");
//    // ((2.0 * x) + (6.0 * x)) => (8.0 * x)
//        System.out.println("Before Simplify:" + new Plus(new Mult(2, "x"), new Mult(6, "x")));
//        System.out.println("After Simplify:" + new Plus(new Mult(2, "x"), new Mult(6, "x")).
//    advancedSimplify());
//        System.out.println("-----");
//    // ((2.0 * x) + (x * 6.0)) => (8.0 * x)
//        System.out.println("Before Simplify:" + new Plus(new Mult(2, "x"), new Mult("x", 6)));
//        System.out.println("After Simplify:" + new Plus(new Mult(2, "x"), new Mult("x", 6)).
//    advancedSimplify());
//        System.out.println("-----");
//    // ((x * 2.0) + (6.0 * x)) => (8.0 * x)
//        System.out.println("Before Simplify:" + new Plus(new Mult("x", 2), new Mult(6, "x")));
//        System.out.println("After Simplify:" + new Plus(new Mult("x", 2), new Mult(6, "x")).
//    advancedSimplify());
//        System.out.println("-----");
//    // ((x * 2.0) + (x * 6.0)) => (8.0 * x)
//        System.out.println("Before Simplify:" + new Plus(new Mult("x", 2), new Mult("x", 6)));
//        System.out.println("After Simplify:" + new Plus(new Mult("x", 2), new Mult("x", 6)).
//    advancedSimplify());
//        System.out.println("-----");
//    // (((x + y) * 2.0) + ((x + y) * 5.0)) => (7.0 * (x + y))
//        System.out.println("Before Simplify:" + new Plus(new Mult(new Plus("x", "y"), 2),
//            new Mult(new Plus("x", "y"), 5)));
//        System.out.println("After Simplify:" + new Plus(new Mult(new Plus("x", "y"), 2),
//            new Mult(new Plus("x", "y"), 5)).advancedSimplify());
//        System.out.println("-----");
//    // (Log(x, y) + Log(x, y)) => (2.0 * Log(x, y))
//        System.out.println("Before Simplify:" + new Plus(new Log("x", "y"), new Log("x", "y")));
//        System.out.println("After Simplify:" + new Plus(new Log("x", "y"), new Log("x", "y")).advancedSimplify());
//        System.out.println("-----");
//    // ((x / y) + (x / y)) => (2.0 * (x / y))
//        System.out.println("Before Simplify:" + new Plus(new Div("x", "y"), new Div("x", "y")));
//        System.out.println("After Simplify:" + new Plus(new Div("x", "y"), new Div("x", "y")).advancedSimplify());
//        System.out.println("-----");
}
