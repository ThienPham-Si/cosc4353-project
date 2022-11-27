package simplification;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Base expression interface.
 */
public abstract class BaseExpression {
    /**
     * A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return result
     * @throws Exception If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    public double evaluate() throws Exception {
        if (this.getVariables().isEmpty()) {
            Map<String, Double> empty = new TreeMap<>();
            return this.evaluate(empty);
        }
        throw new Exception("The expression contains a variable which is not in the assignment");
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return list of the variables
     */
    public abstract List<String> getVariables();

    /**
     * Evaluate the expression using the variable values provided in the assignment, and return the result.  If the
     * expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @param assignment variable values
     * @return result
     * @throws Exception If the expression contains a variable which is not in the assignment, an exception is thrown.
     */
    public abstract double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * Bonus.
     * Returned an advanced simplified version of the current expression.
     *
     * @return advance simplified version of the current expression
     */
    public Expression advancedSimplify() {
        return this.simplify();
    }

    /**
     * Returned a simplified version of the current expression.
     *
     * @return simplified version of the current expression
     */
    public abstract Expression simplify();
}
