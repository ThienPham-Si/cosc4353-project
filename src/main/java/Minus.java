import java.util.Map;

public class Minus extends BinaryExpression{

    public Minus(Expression e1, Expression e2) {
        super(e1, e2);

    }

    public Minus(Expression e1, String var) {
        super(e1, var);
    }

    public Minus(Expression e1, double num) {
        super(e1, num);
    }

    public Minus(String var, Expression e2) {
        super(var, e2);
    }

    public Minus(String var1, String var2) {
        super(var1, var2);
    }
    public Minus(String var, double num) {
        super(var, num);
    }

    public Minus(double num, Expression e2) {
        super(num, e2);
    }

    public Minus(double num, String var) {

        super(num, var);

    }

    public Minus(double num1, double num2) {

        super(num1, num2);

    }

    public double evaluate(Map<String, Double> assignment) {
        return this.getE1().evaluate(assignment) - this.getE2().evaluate(assignment);
    }

    public String toString() {
        return String.format("(%s - %s)", this.getE1().toString(), this.getE2().toString());
    }

    public Minus assign(String var, Expression expression) {
        Expression e1Ass = this.getE1().assign(var, expression);
        Expression e2Ass = this.getE2().assign(var, expression);
        return new Minus(e1Ass, e2Ass);
    }

    public Minus differentiateCalculator(Expression e1Diff, Expression e2Diff, String var) {
        return new Minus(e1Diff, e2Diff);
    }

    public Expression simplify() {
        if (super.simplify() != null) {
            return super.simplify();
        }
        else {
            if (this.getE1().toString().equals("0.0")) {
                return new Neg(this.getE2().simplify());
            }
            else if (this.getE2().simplify().toString().equals("0.0")) {
                return this.getE1().simplify();
            }
            else if (this.getE1().simplify().toString().equals(this.getE2().simplify().toString())) { // X - X = 0
                return new Symbol.Num(0);
            }
            return new Minus(this.getE1().simplify(), this.getE2().simplify());
        }
    }

    public Expression advancedSimplify() {
// (x + y) - (y + x) = 0
        if ((this.getE1() instanceof Plus) && (this.getE2() instanceof Plus) && (this.getE1().toString().
                equals(new Plus(((Plus) this.getE2()).getE2(), ((Plus) this.getE2()).getE1()).toString()))) {
            return new Symbol.Num(0);
// (y + x) - (x + y) = 0
        }
        else if ((this.getE1() instanceof Plus) && (this.getE2() instanceof Plus) && (this.getE2().toString().
                equals(new Plus(((Plus) this.getE1()).getE2(), ((Plus) this.getE1()).getE1()).toString()))) {
            return new Symbol.Num(0);
// (x * y) - (y * x) = 0
        }
        else if ((this.getE1() instanceof Mult) && (this.getE2() instanceof Mult) && (this.getE1().toString().
                equals(new Mult(((Mult) this.getE2()).getE2(), ((Mult) this.getE2()).getE1()).toString()))) {
            return new Symbol.Num(0);
// (y * x) - (x * y) = 0
        }
        else if ((this.getE1() instanceof Mult) && (this.getE2() instanceof Mult) && (this.getE2().toString().
                equals(new Mult(((Mult) this.getE1()).getE2(), ((Mult) this.getE1()).getE1()).toString()))) {
            return new Symbol.Num(0);
        }
        return this.simplify();
    }
}