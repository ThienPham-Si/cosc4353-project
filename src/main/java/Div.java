import java.util.Map;

public class Div extends BinaryExpression implements Expression {

    public Div(Expression e1, Expression e2) {

        super(e1, e2);

    }

    public Div(Expression e1, String var) {

        super(e1, var);
    }


    public Div(Expression e1, double num) {

        super(e1, num);

    }

    /**

     * constructor for variable in left and expression in right.

     *

     * @param var left

     * @param e2 right

     */

    public Div(String var, Expression e2) {

        super(var, e2);

    }

    /**

     * constructor for 2 variables.

     *

     * @param var1 left

     * @param var2 right

     */

    public Div(String var1, String var2) {

        super(var1, var2);

    }

    /**

     * constructor for variable in left and number in right.

     *

     * @param var left

     * @param num right

     */

    public Div(String var, double num) {

        super(var, num);

    }

    /**

     * constructor for number in left and expression in right.

     *

     * @param num left

     * @param e2 right

     */

    public Div(double num, Expression e2) {

        super(num, e2);

    }

    /**

     * constructor for number in left and variable in right.

     *

     * @param num left

     * @param var right

     */

    public Div(double num, String var) {

        super(num, var);

    }

    /**

     * constructor for 2 numbers.

     *

     * @param num1 left

     * @param num2 right

     */

    public Div(double num1, double num2) {

        super(num1, num2);

    }

    /**

     * Evaluate the expression using the variable values provided in the assignment, and return the result. If the

     * expression contains a variable which is not in the assignment, an exception is thrown.

     *

     * @param assignment variable values

     * @return result

     */

    public double evaluate(Map<String, Double> assignment) {

        return this.getE1().evaluate(assignment) / this.getE2().evaluate(assignment);

    }

    /**

     * Returns a nice string representation of the expression.

     *

     * @return string representation

     */

    public String toString() {

        return String.format("(%s / %s)", this.getE1().toString(), this.getE2().toString());

    }

    /**

     * Returns a new expression in which all occurrences of the variable var are replaced with the provided expression

     * (Does not modify the current expression).

     *

     * @param var variable

     * @param expression expression

     * @return new expression

     */

    public Expression assign(String var, Expression expression) {

        Expression e1Ass = this.getE1().assign(var, expression);

        Expression e2Ass = this.getE2().assign(var, expression);

        return new Div(e1Ass, e2Ass);

    }

    /**

     * Calculate the differentiate according to the operator.

     *

     * @param e1Diff expression's differentiate

     * @param e2Diff expression's differentiate

     * @param var variable

     * @return differentiate

     */

    public Expression differentiateCalculator(Expression e1Diff, Expression e2Diff, String var) {

        return new Div(new Minus(new Mult(e1Diff, this.getE2()), new Mult(e2Diff, this.getE1())), new Pow(this.getE2(),

                2));

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

            if (this.getE1().simplify().toString().equals(this.getE2().simplify().toString())) { // x / x = 1

                return new Symbol.Num(1);

            } else if (this.getE2().simplify().toString().equals("1.0")) { // X / 1 = x

                return this.getE1().simplify();

            }

            return new Div(this.getE1().simplify(), this.getE2().simplify());

        }

    }

    /**

     * Bonus.

     * Returned an advanced simplified version of the current expression.

     *

     * @return advance simplified version of the current expression

     */

    public Expression advancedSimplify() {

        if (this.getE1().simplify().toString().equals("0.0")) { // 0 / x = 0

            return new Symbol.Num(0);

        }

        return this.simplify();

    }

}
