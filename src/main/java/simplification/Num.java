package simplification;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

/**
 * Num class.
 */
public class Num implements Expression {
    // members
    private double num;

    /**
     * constructor.
     *
     * @param num number
     */
    public Num(double num) {
        this.num = num;
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
        return this.num;
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return result
     * @throws Exception If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    public double evaluate() throws Exception {
        return this.num;
    }

    /**
     * Returns empty ArrayList because there is no variables in the expression.
     *
     * @return ArrayList
     */
    public List<String> getVariables() {
        return new ArrayList<>();
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return string representation
     */
    public String toString() {
        return String.valueOf(this.num);
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
        return this;
    }

    /**
     * Returns the expression tree resulting from differentiating the current expression relative to variable `var`.
     *
     * @param var variable
     * @return result of differentiate
     */
    public Expression differentiate(String var) {
        return new Num(0);
    }

    /**
     * Returned a simplified version of the current expression.
     *
     * @return simplified version of the current expression
     */
    public Expression simplify() {
        return this;
    }

    /**
     * Bonus.
     * Returned an advanced simplified version of the current expression.
     *
     * @return advance simplified version of the current expression
     */
    public Expression advancedSimplify() {
        return this.simplify();
    }
}
