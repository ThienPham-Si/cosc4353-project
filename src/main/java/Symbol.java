import java.util.ArrayList;
import java.util.List;

public class Symbol extends Expr{

    public static Symbol x = new Symbol("x");
    public static Symbol y = new Symbol("y");
    public static Symbol z = new Symbol("z");
    private String symbolName;
    private String symbolValueExpression;
    private double symbolValue;

    public Symbol(String name) {
        super(name);
        this.label = name;
    }

    public Symbol(String name, String valueExpression) {
        super(name);
        this.label = name;
        this.symbolValueExpression = valueExpression;
    }

    public Symbol(String name, double value) {
        super(name);
        this.label = name;
        this.symbolValue = value;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public String getSymbolValueExpression() {
        return symbolValueExpression;
    }

    public void setSymbolValueExpression(String symbolValueExpression) {
        this.symbolValueExpression = symbolValueExpression;
    }

    public double getSymbolValue() {
        return symbolValue;
    }

    public void setSymbolValue(double symbolValue) {
        this.symbolValue = symbolValue;
    }


    @Override
    public String toString() {
        return this.symbolName;
    }
}
