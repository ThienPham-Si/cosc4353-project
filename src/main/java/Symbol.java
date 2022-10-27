public class Symbol {
    private final String symbol;
    Symbol(String character){
        this.symbol = character;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
