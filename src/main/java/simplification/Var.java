package simplification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Var class.
 */
public class Var implements Expression {
    // members
    private String v;

    /**
     * constructor.
     *
     * @param v variable
     */
    public Var(String v) {
        this.v = v;
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
        if ((assignment != null) && (assignment.containsKey(this.v))) {
            return assignment.get(this.v);
        }
        throw new Exception("The expression contains a variable which is not in the assignment");
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return result
     * @throws Exception If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    public double evaluate() throws Exception {
        Map<String, Double> empty = new TreeMap<>();
        return this.evaluate(empty);
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return list of the variables
     */
    public List<String> getVariables() {
        List<String> variables = new ArrayList<>();
        variables.add(this.v);
        return variables;
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return string representation
     */
    public String toString() {
        return v;
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
        if (this.v.equals(var)) {
            return expression;
        }
        return this;
    }

    /**
     * Returns the expression tree resulting from differentiating the current expression relative to variable `var`.
     *
     * @param var variable
     * @return result of differentiate
     */
    public Expression differentiate(String var) {
        if (this.v.equals(var)) {
            return new Num(1);
        } else {
            return new Num(0);
        }
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
