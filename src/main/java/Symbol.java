import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Symbol implements AST{
    private String symbolName;
    private String symbolValueExpression;
    private double symbolValue;

    public Symbol(String symbolName, double symbolValue) {
        this.symbolName = symbolName;
        this.symbolValue = symbolValue;
	}

    public Symbol(String symbolName, String symbolValueExpression){
        this.symbolName = symbolName;
        this.symbolValueExpression = symbolValueExpression;
    }

    public Symbol(String name) {
        this.symbolName = name;
    }

    @Override
    public AST expand() {
        return this;
    }

    @Override
    public String toString() {
        return this.symbolName;
    }

    public static class Num implements Expression {
        // members
        private double num;

        public Num(double num) {
            this.num = num;
        }

        public double evaluate(Map<String, Double> assignment) throws Exception {
            return this.num;
        }

        public double evaluate() throws Exception {
            return this.num;
        }

        public List<String> getVariables() {
            return new ArrayList<>();
        }

        public String toString() {
            return String.valueOf(this.num);
        }

        public Expression assign(String var, Expression expression) {
            return this;
        }


        public Expression differentiate(String var) {
            return new Num(0);
        }

        public Expression simplify() {
            return this;
        }


        public Expression advancedSimplify() {
            return this.simplify();
        }
    }
}
