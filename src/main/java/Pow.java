import java.util.List;
import java.util.Map;


public class Pow extends BinaryExpression implements Expression {
    public Pow(Expression e1, Expression e2) {
        super(e1, e2);
    }
  public Pow(Expression e1, String var) {
        super(e1, var);
    }

    public Pow(Expression e1, double num) {
        super(e1, num);
    }

    public Pow(String var, Expression e2) {
       super(var, e2);
    }
       public Pow(String var1, String var2) {
            super(var1, var2);
    }

    public Pow(String var, double num) {
        super(var, num);
    }

    public Pow(double num, Expression e2) {
        super(num, e2);
    }

    public Pow(double num, String var) {
        super(num, var);
    }

    public Pow(double num1, double num2) {
        super(num1, num2);
    }


    public double evaluate(Map<String, Double> assignment) {
        return Math.pow(this.getE1().evaluate(assignment), this.getE2().evaluate(assignment));
    }

    public String toString() {
        return String.format("(%s^%s)", this.getE1().toString(), this.getE2().toString());
    }


    public Expression assign(String var, Expression expression) {
        Expression e1Ass = this.getE1().assign(var, expression);
        Expression e2Ass = this.getE2().assign(var, expression);
        return new Pow(e1Ass, e2Ass);
    }

    public Pow getE1() {
        return null;
    }

    public Div differentiateCalculator(Expression e1Diff, Expression e2Diff, String var) {
        List e2Variables = (List) this.getE2().getVariables();
        if ((e2Variables != null) && (e2Variables.contains(var))) {
            Expression tempExponent = new Mult(this.getE2(), new Log(new Var("e"), this.getE1()));
            Expression tempRepresentation = new Pow(new Var("e"), tempExponent);
            return new Mult(tempRepresentation, tempExponent.differentiate(var));
        }
        return new Mult(new Mult(this.getE2(), new Pow(this.getE1(), new Minus(this.getE2(), new Symbol.Num(1)))), e1Diff);
    }

    public Expression simplify() {
        if (super.simplify() != null) {
            return super.simplify();
        } else {
            if (this.getE2().simplify().toString().equals("0.0") || this.getE1().simplify().toString().equals("1.0")) {
                return new Symbol.Num(1);
            } else if (this.getE2().simplify().toString().equals("1.0")) {
                return this.getE1().simplify();
            } else if (this.getE1().simplify().toString().equals("0.0")) {
                return new Symbol.Num(0);
            }
            return new Pow(this.getE1().simplify(), this.getE2().simplify());
        }
    }

    public Expression advancedSimplify() {
       if (this.getE1() instanceof Pow) {
            return new Pow(((Pow) this.getE1()).getE1(), new Mult(((Pow) this.getE1()).getE2(), this.getE2())).
                    simplify().advancedSimplify();
        }
        return this.simplify();
    }
}