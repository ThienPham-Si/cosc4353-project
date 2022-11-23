import java.util.Collection;
import java.util.Map;

public class Expression {
    private BasicOps basicOps = new BasicOps();
    String expressionString;
    private String expressionStringCleaned;
    private String description;

    public Expression(String expression) {
        this.expressionString = expression;
    }

    public void setExpressionString(String expression) {
        this.expressionString = expression;
    }

    public String getExpressionString() {
        return expressionString;
    }

    public <T> T eval() {
        //check if a character exist in a string
        if (this.expressionString.indexOf("=") > -1) {
            int index = this.expressionString.indexOf("=");
            boolean result = (BasicOps.eval(this.expressionString.substring(0, index)) == BasicOps.eval(this.expressionString.substring(index + 1)));
            return (T) (result ? "true" : "false");
        }
        return (T) new double[(int) BasicOps.eval(expressionString)];
    }

    public double evaluate(Map<String, Double> assignment) {
        return Double.parseDouble(null);
    }

    public Collection<? extends String> getVariables() {
        return null;
    }

    public Expression differentiate(String var) {
        return null;
    }

    protected Expression assign(String var, Expression expression) {
        return expression;
    }

    protected Expression simplify() {
        return null;
    }

    protected Expression advancedSimplify() {
        return null;

    }
}

