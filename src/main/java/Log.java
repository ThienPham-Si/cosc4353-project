import java.util.Map;

/**
 * Log class.
 */
public class Log extends BinaryExpression implements Expression {
    /**
     * constructor.
     *
     * @param e1 left
     * @param e2 right
     */
    public Log(Expression e1, Expression e2) {
        super(e1, e2);
    }

    /**
     * constructor for expression in left and variable in right.
     *
     * @param e1  left
     * @param var right
     */
    public Log(Expression e1, String var) {
        super(e1, var);
    }

    /**
     * constructor for expression in left and number in right.
     *
     * @param e1  left
     * @param num right
     */
    public Log(Expression e1, double num) {
        super(e1, num);
    }

    /**
     * constructor for variable in left and expression in right.
     *
     * @param var left
     * @param e2  right
     */
    public Log(String var, Expression e2) {
        super(var, e2);
    }

    /**
     * constructor for 2 variables.
     *
     * @param var1 left
     * @param var2 right
     */
    public Log(String var1, String var2) {
        super(var1, var2);
    }

    /**
     * constructor for variable in left and number in right.
     *
     * @param var left
     * @param num right
     */
    public Log(String var, double num) {
        super(var, num);
    }

    /**
     * constructor for number in left and expression in right.
     *
     * @param num left
     * @param e2  right
     */
    public Log(double num, Expression e2) {
        super(num, e2);
    }

    /**
     * constructor for number in left and variable in right.
     *
     * @param num left
     * @param var right
     */
    public Log(double num, String var) {
        super(num, var);
    }

    /**
     * constructor for 2 numbers.
     *
     * @param num1 left
     * @param num2 right
     */
    public Log(double num1, double num2) {
        super(num1, num2);
    }

    /**
     * Evaluate the expression using the variable values provided in the assignment, and return the result.  If the
     * expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @param assignment variable values
     * @return result
     */
    public double evaluate(Map<String, Double> assignment) {
        return Math.log(this.getE2().evaluate(assignment)) / Math.log(this.getE1().evaluate(assignment));
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return string representation
     */
    public String toString() {
        return String.format("Log(%s, %s)", this.getE1().toString(), this.getE2().toString());
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
        Expression eAss = this.getE1().assign(var, expression);
        Expression baseAss = this.getE2().assign(var, expression);
        return new Log(baseAss, eAss);
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
        return new Div(e2Diff, new Mult(this.getE2(), new Log(new Var("e"), this.getE1())));
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
            // log(x, x) = 1
            if (this.getE2().simplify().toString().equals(this.getE1().simplify().toString())) {
                return new Symbol.Num(1);
            }
            return new Log(this.getE1().simplify(), this.getE2().simplify());
        }
    }
}