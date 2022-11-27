import java.util.Map;
public class Neg extends UnaryExpression implements Expression {
    public Neg(Expression e) {
        super(e);
    }

    public Neg(double num) {
        super(num);
    }

    public Neg(String var) {
        super(var);
    }

    public double evaluate(Map<String, Double> assignment) {
        return -1 * (this.getE().evaluate(assignment));
    }

    public String toString() {
        return String.format("-(%s)", this.getE().toString());
    }

    public Expression assign(String var, Expression expression) {
        Expression eAss = this.getE().assign(var, expression);
        return new Neg(eAss);
    }

    public Expression differentiateCalculator(Expression eDiff, String var) {
        return new Neg(eDiff);
    }

    public Sin simplify() {
        if (super.simplify() != null) {
            return super.simplify();
        }
        else {
            return new Neg(this.getE().simplify());
        }
    }

    public Expression advancedSimplify() {
        if (this.getE() instanceof Neg) { // -(-(x)) = x
            return ((Neg) this.getE()).getE().simplify().advancedSimplify();
        }
        return this.simplify();
    }
}

