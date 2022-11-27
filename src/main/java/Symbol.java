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



    @Override
    public String toString() {
        return this.symbolName;
    }
}
