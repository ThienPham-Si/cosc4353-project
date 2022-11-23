import java.util.Map;
public class Mult extends BinaryExpression implements Expression {
    public Mult(Expression e1, Expression e2) {
        super(e1, e2);
    }

    public Mult(Expression e1, String var) {
        super(e1, var);
    }

    public Mult(Expression e1, double num) {
        super(e1, num);
    }

    public Mult(String var, Expression e2) {
        super(var, e2);
    }

    public Mult(String var1, String var2) {
        super(var1, var2);
    }

    public Mult(String var, double num) {
        super(var, num);
    }

    public Mult(double num, Expression e2) {
        super(num, e2);
    }
    public Mult(double num, String var) {
        super(num, var);
    }

    public Mult(double num1, double num2) {
        super(num1, num2);
    }

    public double evaluate(Map<String, Double> assignment) {
        return this.getE1().evaluate(assignment) * this.getE2().evaluate(assignment);
    }

    public String toString() {
        return String.format("(%s * %s)", this.getE1().toString(), this.getE2().toString());
    }

    public Expression assign(String var, Expression expression) {
        Expression e1Ass = this.getE1().assign(var, expression);
        Expression e2Ass = this.getE2().assign(var, expression);
        return new Mult(e1Ass, e2Ass);
    }

    public Expression differentiateCalculator(Expression e1Diff, Expression e2Diff, String var) {
        return new Plus(new Mult(e1Diff, this.getE2()), new Mult(e2Diff, this.getE1()));
    }

    public Expression simplify() {
        if (super.simplify() != null) {
            return super.simplify();
        }
        else {
// 0 * x = 0 or x * 0 = 0
            if (this.getE1().simplify().toString().equals("0.0") || this.getE2().simplify().toString().equals("0.0")) {
                return new Symbol.Num(0);
            } else if (this.getE1().simplify().toString().equals("1.0")) { // 1 * x = x
                return this.getE2().simplify();
            } else if (this.getE2().simplify().toString().equals("1.0")) { // x * 1 = x
                return this.getE1().simplify();
            }
            return new Mult(this.getE1().simplify(), this.getE2().simplify());
        }
    }

    public Expression advancedSimplify() {
        if (this.getE1().toString().equals(this.getE2().toString())) { // x * x = x^2
            return new Pow(this.getE1(), new Symbol.Num(2)).simplify().advancedSimplify();
        }
        else if ((this.getE2() instanceof Pow) && (this.getE1().toString().equals(((Pow) this.getE2()).getE1().
                toString()))) { // x * (x^2) = x^3
            return new Pow(this.getE1(), new Plus(((Pow) this.getE2()).getE2(), new Symbol.Num(1))).simplify().
                    advancedSimplify();
        }
        else if ((this.getE1() instanceof Pow) && (this.getE2().toString().equals(((Pow) this.getE1()).getE1().
                toString()))) { // (x^2) * x = x^3
            return new Pow(this.getE2(), new Plus(((Pow) this.getE1()).getE2(), new Symbol.Num(1))).simplify().
                    advancedSimplify();
        }
        return this.simplify();
    }
}