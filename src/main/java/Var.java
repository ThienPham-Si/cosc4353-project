import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Var implements Expression {
    // members
    private String v;

    public Var(String v) {
        this.v = v;
    }


    public double evaluate(Map<String, Double> assignment) throws Exception {
        if ((assignment != null) && (assignment.containsKey(this.v))) {
            return assignment.get(this.v);
        }
        throw new Exception("The expression contains a variable which is not in the assignment");
    }


    public double evaluate() throws Exception {
        Map<String, Double> empty = new TreeMap<>();
        return this.evaluate(empty);
    }


    public List<String> getVariables() {
        List<String> variables = new ArrayList<>();
        variables.add(this.v);
        return variables;
    }


    public String toString() {
        return v;
    }


    public Expression assign(String var, Expression expression) {
        if (this.v.equals(var)) {
            return expression;
        }
        return this;
    }

    public Expression differentiate(String var) {
        if (this.v.equals(var)) {
            return new Symbol.Num(1);
        } else {
            return new Symbol.Num(0);
        }
    }

    public Expression simplify() {
        return this;
    }

    public Expression advancedSimplify() {
        return this.simplify();
    }
}