import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Unary expression interface.
 */
public abstract class UnaryExpression extends BaseExpression {
    // members
    private Expression e;

    /**
     * constructor for expression.
     *
     * @param e expression
     */
    public UnaryExpression(Expression e) {
        this.e = e;
    }

    /**
     * constructor for number.
     *
     * @param num number
     */
    public UnaryExpression(double num) {
        this(new Symbol.Num(num));
    }

    /**
     * constructor for variable.
     *
     * @param var variable
     */
    public UnaryExpression(String var) {
        this(new Var(var));
    }

    /**
     * get member e.
     *
     * @return e
     */
    public Expression getE() {
        return this.e;
    }


    public List<String> getVariables() {
        Set<String> variablesSet = new HashSet<String>();
        if (this.e.getVariables() != null) {
            variablesSet.addAll(this.e.getVariables());
        }
        List<String> variablesList = new ArrayList<>();
        variablesList.addAll(variablesSet);
        return variablesList;
    }

    public Expression differentiate(String var) {
        Expression eDiff = this.e.differentiate(var);
        return differentiateCalculator(eDiff, var);
    }

    public abstract Expression differentiateCalculator(Expression eDiff, String var);

    public Expression simplify() {
        try {
            return new Symbol.Num(this.evaluate());
        } catch (Exception ex) {
            return null;
        }
    }
}