import java.util.Map;
public class Log extends BinaryExpression implements Expression {
    public Log(Expression e1, Expression e2) {
        super(e1, e2);
    }

    public Log(Expression e1, String var) {
        super(e1, var);
    }

    public Log(Expression e1, double num) {
        super(e1, num);
    }

    public Log(String var, Expression e2) {
        super(var, e2);
    }

    public Log(String var1, String var2) {
        super(var1, var2);
    }

    public Log(String var, double num) {
        super(var, num);
    }

    public Log(double num, Expression e2) {
        super(num, e2);
    }

    public Log(double num, String var) {
        super(num, var);
    }

    public Log(double num1, double num2) {
        super(num1, num2);
    }

Map<String, Double> assignment) throws Exception {
        return Math.log(this.getE2().evaluate(assignment)) / Math.log(this.getE1().evaluate(assignment));
    }
oString() {
        return String.format("Log(%s, %s)", this.getE1().toString(), this.getE2().toString());
    }
    public Expression assign(String var, Expression expression) {
        Expression eAss = this.getE1().assign(var, expression);
        Expression baseAss = this.getE2().assign(var, expression);
        return new Log(baseAss, eAss);
    }

    public Expression differentiateCalculator(Expression e1Diff, Expression e2Diff, String var) {
        return new Div(e2Diff, new Mult(this.getE2(), new Log(new Var("e"), this.getE1())));
    }

    public Expression simplify() {
        if (super.simplify() != null) {
            return super.simplify();
        } else {
            // log(x, x) = 1
            if (this.getE2().simplify().toString().equals(this.getE1().simplify().toString())) {
                return new Num(1);
            }
            return new Log(this.getE1().simplify(), this.getE2().simplify());
        }
    }
}