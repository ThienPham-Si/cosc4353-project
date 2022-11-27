import java.util.Map;

public class Cos extends UnaryExpression{


    public Cos(Expression e) {
        super(e);
    }

    public Cos(double num) {
        super(num);
    }

    public Cos(String var) {
        super(var);
    }


    public double evaluate(Map<String, Double> assignment) {
        return Math.cos(Math.toRadians((Double) this.getE().evaluate(assignment)));
    }


    public String toString() {
        return String.format("Cos(%s)", this.getE().toString());
    }


    public Cos assign(String var, Expression expression) {
        Expression eAss = this.getE().assign(var, expression);
        return new Cos(eAss);
    }

    public Expression differentiateCalculator(Expression eDiff, String var) {
        return new Mult(new Neg(new Sin(this.getE())), eDiff);
    }

    public Cos simplify() {
        if (super.simplify() != null) {
            return super.simplify();
        } else {
            return new Cos(this.getE().simplify());
        }
    }
}