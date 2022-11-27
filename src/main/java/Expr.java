public class Expr {
    private BasicOps basicOps = new BasicOps();
    String expressionString;
    private String expressionStringCleaned;
	private String description;
    protected String label = null;

    public Expr(String expression) {
        this.expressionString = expression;
	}

    public void setExpressionString(String expression){
        this.expressionString = expression;
    }
    public Expr setLabel(String label) {
        this.label = label;
        return this;
    }
    public String getExpressionString() {
		return expressionString;
	}

    public <T> T eval(){
        //check if a character exist in a string
        if (this.expressionString.indexOf("=") > -1){
            int index = this.expressionString.indexOf("=");
            boolean result = (basicOps.eval(this.expressionString.substring(0, index)) == basicOps.eval(this.expressionString.substring(index+1)));
            return (T) (result?"true":"false");
        }
        return (T) new Double(basicOps.eval(expressionString));
    }

    // public <T> T func(Object obj){
    //     if(obj instanceof Class1)
    //     {
    //         return  (T) new Integer(1);
    //     }
    //     else if(obj instanceof Class2)
    //     {
    //         return  (T) "asdf";
    //     }
    //     else
    //     {
    //         return  (T) new Double(1.7);
    //     }
    // }



}
