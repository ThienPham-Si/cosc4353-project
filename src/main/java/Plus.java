import java.util.Map;

/**
 * Plus class.
 */
public class Plus extends BinaryExpression implements Expression {

    /**
     * constructor.
     *
     * @param e1 left
     * @param e2 right
     */
    public Plus(Expression e1, Expression e2) {
        super(e1, e2);
    }

    /**
     * constructor for expression in left and variable in right.
     *
     * @param e1  left
     * @param var right
     */
    public Plus(Expression e1, String var) {
        super(e1, var);
    }

    /**
     * constructor for expression in left and number in right.
     *
     * @param e1  left
     * @param num right
     */
    public Plus(Expression e1, double num) {
        super(e1, num);
    }

    /**
     * constructor for variable in left and expression in right.
     *
     * @param var left
     * @param e2  right
     */
    public Plus(String var, Expression e2) {
        super(var, e2);
    }

    /**
     * constructor for 2 variables.
     *
     * @param var1 left
     * @param var2 right
     */
    public Plus(String var1, String var2) {
        super(var1, var2);
    }

    /**
     * constructor for variable in left and number in right.
     *
     * @param var left
     * @param num right
     */
    public Plus(String var, double num) {
        super(var, num);
    }

    /**
     * constructor for number in left and expression in right.
     *
     * @param num left
     * @param e2  right
     */
    public Plus(double num, Expression e2) {
        super(num, e2);
    }

    /**
     * constructor for number in left and variable in right.
     *
     * @param num left
     * @param var right
     */
    public Plus(double num, String var) {
        super(num, var);
    }

    /**
     * constructor for 2 numbers.
     *
     * @param num1 left
     * @param num2 right
     */
    public Plus(double num1, double num2) {
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
        return this.getE1().evaluate(assignment) + this.getE2().evaluate(assignment);
    }

    /**
     * Returns a nice string representation of the expression.
     *
     * @return string representation
     */
    public String toString() {
        return String.format("(%s + %s)", this.getE1().toString(), this.getE2().toString());
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
        return new Plus(e1Ass, e2Ass);
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
        return new Plus(e1Diff, e2Diff);
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
            if (this.getE1().simplify().toString().equals("0.0")) { // 0 + x = x
                return this.getE2().simplify();
            } else if (this.getE2().simplify().toString().equals("0.0")) { // x + 0 = x
                return this.getE1().simplify();
            }
            return new Plus(this.getE1().simplify(), this.getE2().simplify());
        }
    }

    /**
     * Bonus.
     * Returned an advanced simplified version of the current expression.
     *
     * @return advance simplified version of the current expression
     */
    public Expression advancedSimplify() {
        if (this.getE1() instanceof Mult && this.getE2() instanceof Mult) {
            // ((2x) + (4x)) => 6*x
            if (((Mult) this.getE1()).getE2().toString().equals(((Mult) this.getE2()).getE2().toString())
                    && ((Mult) this.getE1()).getE1() instanceof Symbol.Num && ((Mult) this.getE2()).getE1() instanceof Symbol.Num) {
                try {
                    double newNum = new Plus(((Mult) this.getE1()).getE1(), ((Mult) this.getE2()).getE1()).evaluate();
                    return new Mult(newNum, ((Mult) this.getE1()).getE2()).simplify().advancedSimplify();
                } catch (Exception ex) {
                    return null;
                }
                // ((2x) + (x4)) => 6*x
            } else if (((Mult) this.getE1()).getE2().toString().equals(((Mult) this.getE2()).getE1().toString())
                    && ((Mult) this.getE1()).getE1() instanceof Symbol.Num && ((Mult) this.getE2()).getE2() instanceof Symbol.Num) {
                try {
                    double newNum = new Plus(((Mult) this.getE1()).getE1(), ((Mult) this.getE2()).getE2()).evaluate();
                    return new Mult(newNum, ((Mult) this.getE1()).getE2()).simplify().advancedSimplify();
                } catch (Exception ex) {
                    return null;
                }
                // ((x2) + (4x)) => 6*x
            } else if (((Mult) this.getE1()).getE1().toString().equals(((Mult) this.getE2()).getE2().toString())
                    && ((Mult) this.getE1()).getE2() instanceof Symbol.Num && ((Mult) this.getE2()).getE1() instanceof Symbol.Num) {
                try {
                    double newNum = new Plus(((Mult) this.getE1()).getE2(), ((Mult) this.getE2()).getE1()).evaluate();
                    return new Mult(newNum, ((Mult) this.getE1()).getE1()).simplify().advancedSimplify();
                } catch (Exception ex) {
                    return null;
                }
                // ((x2) + (x4)) => 6*x
            } else if (((Mult) this.getE1()).getE1().toString().equals(((Mult) this.getE2()).getE1().toString())
                    && ((Mult) this.getE1()).getE2() instanceof Symbol.Num && ((Mult) this.getE2()).getE2() instanceof Symbol.Num) {
                try {
                    double newNum = new Plus(((Mult) this.getE1()).getE2(), ((Mult) this.getE2()).getE2()).evaluate();
                    return new Mult(newNum, ((Mult) this.getE1()).getE1()).simplify().advancedSimplify();
                } catch (Exception ex) {
                    return null;
                }
            }
        } else if (this.getE1().toString().equals(this.getE2().toString())) { // x + x = 2 * x
            return new Mult(new Symbol.Num(2), this.getE1()).simplify().advancedSimplify();
        } else if ((this.getE1() instanceof Mult) && (this.getE2() instanceof Mult) && ((Mult) this.getE1()).getE2().
                toString().equals(((Mult) this.getE2()).getE2().toString())) { // 2x + 3x = 5x
            return new Mult(new Plus(((Mult) this.getE1()).getE1(), ((Mult) this.getE2()).getE1()), ((Mult)
                    this.getE1()).getE2()).simplify().advancedSimplify();
        } else if ((this.getE1() instanceof Mult) && (this.getE2() instanceof Mult) && ((Mult) this.getE1()).getE1().
                toString().equals(((Mult) this.getE2()).getE2().toString())) { // x2 + 3x = 5x
            return new Mult(new Plus(((Mult) this.getE1()).getE2(), ((Mult) this.getE2()).getE1()), ((Mult)
                    this.getE1()).getE1()).simplify().advancedSimplify();
        } else if ((this.getE1() instanceof Mult) && (this.getE2() instanceof Mult) && ((Mult) this.getE1()).getE2().
                toString().equals(((Mult) this.getE2()).getE1().toString())) { // 2x + x3 = 5x
            return new Mult(new Plus(((Mult) this.getE1()).getE1(), ((Mult) this.getE2()).getE2()), ((Mult)
                    this.getE1()).getE2()).simplify().advancedSimplify();
        } else if ((this.getE1() instanceof Mult) && (this.getE2() instanceof Mult) && ((Mult) this.getE1()).getE1().
                toString().equals(((Mult) this.getE2()).getE1().toString())) { // x2 + x3 = 5x
            return new Mult(new Plus(((Mult) this.getE1()).getE2(), ((Mult) this.getE2()).getE2()), ((Mult)
                    this.getE1()).getE1()).simplify().advancedSimplify();
        } else if ((this.getE1() instanceof Mult) && (!(this.getE2() instanceof Mult)) && (((Mult) this.getE1()).
                getE2().toString().equals(this.getE2().toString()))) { // 2x + x = 3x
            return new Mult(new Plus(((Mult) this.getE1()).getE1(), new Symbol.Num(1)), this.getE2()).simplify().
                    advancedSimplify();
        } else if ((!(this.getE1() instanceof Mult)) && (this.getE2() instanceof Mult) && (((Mult) this.getE2()).
                getE2().toString().equals(this.getE1().toString()))) { // x + 2x = 3x
            return new Mult(new Plus(((Mult) this.getE2()).getE1(), new Symbol.Num(1)), this.getE1()).simplify().
                    advancedSimplify();
        }
        return this.simplify();
    }
}