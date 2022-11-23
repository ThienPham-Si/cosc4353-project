import java.util.ArrayList;
import java.util.List;

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
}
