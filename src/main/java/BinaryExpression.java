import java.util.ArrayList;

import java.util.HashSet;

import java.util.List;

import java.util.Set;

/**

 * Binary expression interface.

 */

public abstract class BinaryExpression{

// members

    public Expression e1;

    public Expression e2;

    /**

     * constructor for 2 expressions.

     *

     * @param e1 left

     * @param e2 right

     */

    public BinaryExpression(Expression e1, Expression e2) {

        this.e1 = e1;

        this.e2 = e2;

    }

    /**

     * constructor for expression in left and variable in right.

     *

     * @param e1 left

     * @param var right

     */

    public BinaryExpression(Expression e1, String var) {

        this(e1, new Var(var));

    }

    /**

     * constructor for expression in left and number in right.

     *

     * @param e1 left

     * @param num right

     */

    public BinaryExpression(Expression e1, double num) {

        this(e1, new Symbol.Num(num));

    }

    /**

     * constructor for variable in left and expression in right.

     *

     * @param var left

     * @param e2 right

     */

    public BinaryExpression(String var, Expression e2) {

        this(new Var(var), e2);

    }

    /**

     * constructor for 2 variables.

     *

     * @param var1 left

     * @param var2 right

     */

    public BinaryExpression(String var1, String var2) {

        this(new Var(var1), new Var(var2));

    }

    /**

     * constructor for variable in left and number in right.

     *

     * @param var left

     * @param num right

     */

    public BinaryExpression(String var, double num) {

        this(new Var(var), new Symbol.Num(num));

    }

    /**

     * constructor for number in left and expression in right.

     *

     * @param num left

     * @param e2 right

     */

    public BinaryExpression(double num, Expression e2) {

        this(new Symbol.Num(num), e2);

    }

    /**

     * constructor for number in left and variable in right.

     *

     * @param num left

     * @param var right

     */

    public BinaryExpression(double num, String var) {

        this(new Symbol.Num(num), new Var(var));

    }

    /**

     * constructor for 2 numbers.

     *

     * @param num1 left

     * @param num2 right

     */

    public BinaryExpression(double num1, double num2) {

        this(new Symbol.Num(num1), new Symbol.Num(num2));

    }

    /**

     * get member e1.

     *

     * @return e1

     */

    public Expression getE1() {

        return this.e1;

    }

    /**

     * get member e2.

     *

     * @return e2

     */

    public Expression getE2() {

        return this.e2;

    }

    /**

     * Returns a list of the variables in the expression.

     *

     * @return list of the variables

     */

    public List<String> getVariables() {

        Set<String> variablesSet = new HashSet<String>();

        if (!this.e1.getVariables().isEmpty()) {

            variablesSet.addAll(this.e1.getVariables());

        }

        if (!this.e2.getVariables().isEmpty()) {

            variablesSet.addAll(this.e2.getVariables());

        }

        List<String> variablesList = new ArrayList<>();

        variablesList.addAll(variablesSet);

        return variablesList;

    }

    public Expression differentiate(String var) {

        Expression e1Diff = this.e1.differentiate(var);

        Expression e2Diff = this.e2.differentiate(var);

        return differentiateCalculator(e1Diff, e2Diff, var);

    }

    /**
     * Calculate the differentiate according to the operator.
     *
     * @param e1Diff expression's differentiate
     * @param e2Diff expression's differentiate
     * @param var    variable
     * @return differentiate
     */

    public abstract Minus differentiateCalculator(Expression e1Diff, Expression e2Diff, String var);

    /**
     * Returned a simplified version of the current expression.
     *
     * @return simplified version of the current expression
     */

    public Object simplify() {

        try {

            return new Symbol.Num(this.());

        } catch (Exception ex) {

            return null;

        }

    }

}