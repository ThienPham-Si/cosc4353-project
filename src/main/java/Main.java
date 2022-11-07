import java.util.*;

public class Main {
    public static void main(String[] args){

        ///////////////////// Symbol
        Symbol x = new Symbol("x", 4);

        ///////////////////// Expression
        // basic calculation
        Expression ex1 = new Expression("2 + 3");
        System.out.println(ex1.getExpressionString() + " = " + ex1.eval());

        // power
        ex1.setExpressionString("2^3 + 2");
        System.out.println(ex1.getExpressionString() + " = " + ex1.eval());

        // sin, cos 
        ex1.setExpressionString("sin(45) + cos(45)");
        System.out.println(ex1.getExpressionString() + " = " + ex1.eval());

        // relation
        ex1.setExpressionString("3+3 = 7");
        System.out.println(ex1.getExpressionString() + " is " + ex1.eval());
    }
}
