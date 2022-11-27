package simplification;

import java.util.List;
import java.util.Map;

/**
 * Pow class.
 */
public class Pow extends BinaryExpression implements Expression {
    /**
     * constructor.
     *
     * @param e1 left
     * @param e2 right
     */
    public Pow(Expression e1, Expression e2) {
        super(e1, e2);
    }

    /**
     * constructor for expression in left and variable in right.
     *
     * @param e1  left
     * @param var right
     */
    public Pow(Expression e1, String var) {
        super(e1, var);
    }

    /**
     * constructor for expression in left and number in right.
     *
     * @param e1  left
     * @param num right
     */
    public Pow(Expression e1, double num) {
        super(e1, num);
    }

    /**
     * constructor for variable in left and expression in right.
     *
     * @param var left
     * @param e2  right
     */
    public Pow(String var, Expression e2) {
        super(var, e2);
    }

    /**
     * constructor for 2 variables.
     *
     * @param var1 left
     * @param var2 right
     */
    public Pow(String var1, String var2) {
        super(var1, var2);
    }

    /**
     * constructor for variable in left and number in right.
     *
     * @param var left
     * @param num right
     */
    public Pow(String var, double num) {
        super(var, num);
    }

    /**
     * constructor for number in left and expression in right.
     *
     * @param num left
     * @param e2  right
     */
    public Pow(double num, Expression e2) {
        super(num, e2);
    }

    /**
     * constructor for number in left and variable in right.
     *
     * @param num left
     * @param var right
     */
    public Pow(double num, String var) {
        super(num, var);
    }

    /**
     * constructor for 2 numbers.
     *
     * @param num1 left
     * @param num2 right
     */
    public Pow(double num1, double num2) {
        super(num1, num2);
    }

    /**
     * Evaluate the expression using the variable values provided in the assignment, and return the result.  If the
     * expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @param assignment variable values
     * @return result
     * @throws Exception If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.pow(this.getE1().evaluate(assignment), this.getE2().evaluate(assignment));
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return string representation
     */
    public String toString() {
        return String.format("(%s^%s)", this.getE1().toString(), this.getE2().toString());
    }

    /**
     * Returns a new expression in which all occurrences of the variable var are replaced with the provided expression
     * (Does not modify the current expression).
     *
     * @param var        variable
     * @param expression expression
     * @return new expression
     */
    public Expression assign(String var, Expression expression) {
        Expression e1Ass = this.getE1().assign(var, expression);
        Expression e2Ass = this.getE2().assign(var, expression);
        return new Pow(e1Ass, e2Ass);
    }

    /**
     * Calculate the differentiate according to the operator.
     *
     * @param e1Diff expression's differentiate
     * @param e2Diff expression's differentiate
     * @param var    variable
     * @return differentiate
     */
    public Expression differentiateCalculator(Expression e1Diff, Expression e2Diff, String var) {
        List e2Variables = this.getE2().getVariables();
        if ((e2Variables != null) && (e2Variables.contains(var))) {
            Expression tempExponent = new Mult(this.getE2(), new Log(new Var("e"), this.getE1()));
            Expression tempRepresentation = new Pow(new Var("e"), tempExponent);
            return new Mult(tempRepresentation, tempExponent.differentiate(var));
        }
        return new Mult(new Mult(this.getE2(), new Pow(this.getE1(), new Minus(this.getE2(), new Num(1)))), e1Diff);
    }

    /**
     * Returned a simplified version of the current expression.
     *
     * @return simplified version of the current expression
     */
    public Expression simplify() {
        if (super.simplify() != null) {
            return super.simplify();
        } else {
            if (this.getE2().simplify().toString().equals("0.0") || this.getE1().simplify().toString().equals("1.0")) {
                return new Num(1);
            } else if (this.getE2().simplify().toString().equals("1.0")) {
                return this.getE1().simplify();
            } else if (this.getE1().simplify().toString().equals("0.0")) {
                return new Num(0);
            }
            return new Pow(this.getE1().simplify(), this.getE2().simplify());
        }
    }

    /**
     * Bonus.
     * Returned an advanced simplified version of the current expression.
     *
     * @return advance simplified version of the current expression
     */
    public Expression advancedSimplify() {
        if (this.getE1() instanceof Pow) {
            return new Pow(((Pow) this.getE1()).getE1(), new Mult(((Pow) this.getE1()).getE2(), this.getE2())).
                    simplify().advancedSimplify();
        }
        return this.simplify();
    }
}
