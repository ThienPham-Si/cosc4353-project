package simplification;

import java.util.Map;

/**
 * Sin class.
 */
public class Sin extends UnaryExpression implements Expression {
    /**
     * constructor.
     *
     * @param e var or num
     */
    public Sin(Expression e) {
        super(e);
    }

    /**
     * constructor for number.
     *
     * @param num number
     */
    public Sin(double num) {
        super(num);
    }

    /**
     * constructor for variable.
     *
     * @param var variable
     */
    public Sin(String var) {
        super(var);
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
        return Math.sin(Math.toRadians(this.getE().evaluate(assignment)));
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return string representation
     */
    public String toString() {
        return String.format("Sin(%s)", this.getE().toString());
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
        Expression eAss = this.getE().assign(var, expression);
        return new Sin(eAss);
    }

    /**
     * Calculate the differentiate according to the operator.
     *
     * @param eDiff expression's differentiate
     * @param var   variable
     * @return differentiate
     */
    public Expression differentiateCalculator(Expression eDiff, String var) {
        return new Mult(new Cos(this.getE()), eDiff);
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
            return new Sin(this.getE().simplify());
        }
    }
}
