package simplification;

import java.util.Map;
import java.util.List;

/**
 * Expression interface.
 */
public interface Expression {
    /**
     * Evaluate the expression using the variable values provided in the assignment, and return the result.  If the
     * expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @param assignment variable values
     * @return result
     * @throws Exception If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return result
     * @throws Exception If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    double evaluate() throws Exception;

    /**
     * Returns a list of the variables in the expression.
     *
     * @return list of the variables
     */
    List<String> getVariables();

    /**
     * Returns a nice string representation of the expression.
     *
     * @return string representation
     */
    String toString();

    /**
     * Returns a new expression in which all occurrences of the variable var are replaced with the provided expression
     * (Does not modify the current expression).
     *
     * @param var        variable
     * @param expression expression
     * @return new expression
     */
    Expression assign(String var, Expression expression);

    /**
     * Returns the expression tree resulting from differentiating the current expression relative to variable `var`.
     *
     * @param var variable
     * @return result of differentiate
     */
    Expression differentiate(String var);

    /**
     * Returned a simplified version of the current expression.
     *
     * @return simplified version of the current expression
     */
    Expression simplify();

    /**
     * Bonus.
     * Returned an advanced simplified version of the current expression.
     *
     * @return advance simplified version of the current expression
     */
    Expression advancedSimplify();
}