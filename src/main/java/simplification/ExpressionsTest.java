package simplification;

import java.util.Map;
import java.util.TreeMap;

/**
 * An Expressions test.
 */
public class ExpressionsTest {
    /**
     * main.
     *
     * @param args null
     */
    public static void main(String[] args) {
        try {
            // Create the expression (2x) + (sin(4y)) + (e^x).
            Expression expression = new Plus(new Plus(new Mult(2, "x"), new Sin(new Mult(4, "y"))),
                    new Pow("e", "x"));
            // Print the expression.
            System.out.println(expression);
            // Print the value of the expression with (x=2,y=0.25,e=2.71).
            Map<String, Double> assignment = new TreeMap<String, Double>();
            assignment.put("x", 2.0);
            assignment.put("y", 0.25);
            assignment.put("e", 2.71);
            System.out.println(expression.evaluate(assignment));
            // Print the differentiated expression according to x.
            System.out.println(expression.differentiate("x"));
            // Print the value of the differentiated expression according to x with the assignment above.
            System.out.println(expression.differentiate("x").evaluate(assignment));
            // Print the simplified differentiated expression.
            System.out.println(expression.differentiate("x").simplify());
        } catch (Exception ex) {
            return;
        }
    }
}
