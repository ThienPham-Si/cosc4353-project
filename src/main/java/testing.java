import simplification.*;
import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.math.MathException;

import java.util.Arrays;
import java.util.Scanner;

public class testing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

//        System.out.println("Enter the expression");
//        String exp = sc.next();
//        exp = exp.replaceAll("\\s", "");
//        String[] operators = exp.split("(?<=[-+*/])|(?=[-+*/])");
//        Expression[] binaryExpressions = new Expression[operators.length];
//        for (int i = 0; i < operators.length; i++) {
//            if(i%2==0){
//                String[] part = operators[i].split("(?<=\\d)(?=\\D)");
//                int coeff = Integer.parseInt(part[0]);
//                String var = part[1];
//                binaryExpressions[i] = new Mult(coeff, var);
//            }
//        }
//
//        for (int i = 1; i < operators.length; i+=2) {
//            switch ((operators[i])) {
//                case "+" ->
//                    System.out.println(new Plus(binaryExpressions[0], binaryExpressions[2]).advancedSimplify());
//                case "-" ->
//                        System.out.println(new Minus(binaryExpressions[0], binaryExpressions[2]).advancedSimplify());
//                case "*" ->
//                        System.out.println(new Mult(binaryExpressions[0], binaryExpressions[2]).advancedSimplify());
//                case "/" ->
//                        System.out.println(new Div(binaryExpressions[0], binaryExpressions[2]).advancedSimplify());
//                default -> {
//                }
//            }
//        }


        try {
            ExprEvaluator util = new ExprEvaluator();

            IExpr result = util.eval("ExpandAll(-2(3u-x)-v)");
            // print: -6*u-v+2*x
            System.out.println(result.toString());

            // Show an expression in the Java form:
            String javaForm = util.toJavaForm("ExpandAll(-2(3u-x)-v)");
            // prints: ExpandAll(Plus(Times(CN2,Plus(Times(C3,u),Negate(x))),Negate(v)))
            System.out.println(javaForm.toString());

            // use the JavaForm:
//            IAST function = ExpandAll(Plus(Times(CN2, Plus(Times(C3, u), Negate(x))), Negate(v)));
//            result = util.evaluate(function);
//            // print: -6*u-v+2*x
//            System.out.println(result.toString());
//
//
//            // set the value of a variable "a" to 10
//            IExpr result = util.eval("a=10");
//            // print: 10
//            System.out.println("Out[6]: " + result.toString());
//
//            // do a calculation with variable "a"
//            result = util.eval("a*3+b");
//            // print: 30+b
//            System.out.println("Out[7]: " + result.toString());
//
//            // Do a calculation in "numeric mode" with the N() function
//            // Note: single character identifiers are case sensistive
//            // (the "N()" function identifier must be written as upper case
//            // character)
//            result = util.eval("N(sinh(5))");
//            // print: 74.20321057778875
//            System.out.println("Out[8]: " + result.toString());
//
//            // define a function with a recursive factorial function definition.
//            // Note: fac(0) is the stop condition.
//            result = util.eval("fac(x_Integer):=x*fac(x-1);fac(0)=1");
//            // now calculate factorial of 10:
//            result = util.eval("fac(10)");
//            // print: 3628800
//            System.out.println("Out[9]: " + result.toString());
        } catch (SyntaxError e) {
            // catch Symja parser errors here
            System.out.println(e.getMessage());
        } catch (MathException me) {
            // catch Symja math errors here
            System.out.println(me.getMessage());
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
        } catch (final StackOverflowError soe) {
            System.out.println(soe.getMessage());
        } catch (final OutOfMemoryError oome) {
            System.out.println(oome.getMessage());
        }

    }
}
