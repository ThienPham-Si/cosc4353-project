public class simplify {

    public static void main(String[] args) {
        simplify examples = new simplify();
        examples.powerSimplify();
        examples.plusSimplify();
        examples.negSimplify();
        examples.minusSimplify();
        examples.divSimplify();
    }
 //power conversion
    private void powerSimplify() {
        System.out.println("Power simplify examples:");
// ((x^y)^Z) => (x^(y * Z))
        System.out.println("Before Simplify:" + new Pow(new Pow("x", "y"), "Z"));
        System.out.println("After Simplify:" + new Pow(new Pow("x", "y"), "Z").advancedSimplify());
        System.out.println("-----");
// (((x^y)^Z)^x) => ((x^y)^(Z * x))
        System.out.println("Before Simplify:" + new Pow(new Pow(new Pow("x", "y"), "Z"), "x"));
        System.out.println("After Simplify:" + new Pow(new Pow(new Pow("x", "y"), "Z"), "x").advancedSimplify());
        System.out.println("-----");
    }

    private void plusSimplify() {
        System.out.println("Plus simplify examples:");
// ((2.0 * x) + (6.0 * x)) => (8.0 * x)
        System.out.println("Before Simplify:" + new Plus(new Mult(2, "x"), new Mult(6, "x")));
        System.out.println("After Simplify:" + new Plus(new Mult(2, "x"), new Mult(6, "x")).
                advancedSimplify());
        System.out.println("-----");
// ((2.0 * x) + (x * 6.0)) => (8.0 * x)
        System.out.println("Before Simplify:" + new Plus(new Mult(2, "x"), new Mult("x", 6)));
        System.out.println("After Simplify:" + new Plus(new Mult(2, "x"), new Mult("x", 6)).
                advancedSimplify());
        System.out.println("-----");
// ((x * 2.0) + (6.0 * x)) => (8.0 * x)
        System.out.println("Before Simplify:" + new Plus(new Mult("x", 2), new Mult(6, "x")));
        System.out.println("After Simplify:" + new Plus(new Mult("x", 2), new Mult(6, "x")).
                advancedSimplify());
        System.out.println("-----");
// ((x * 2.0) + (x * 6.0)) => (8.0 * x)
        System.out.println("Before Simplify:" + new Plus(new Mult("x", 2), new Mult("x", 6)));
        System.out.println("After Simplify:" + new Plus(new Mult("x", 2), new Mult("x", 6)).
                advancedSimplify());
        System.out.println("-----");
// (((x + y) * 2.0) + ((x + y) * 5.0)) => (7.0 * (x + y))
        System.out.println("Before Simplify:" + new Plus(new Mult(new Plus("x", "y"), 2),
                new Mult(new Plus("x", "y"), 5)));
        System.out.println("After Simplify:" + new Plus(new Mult(new Plus("x", "y"), 2),
                new Mult(new Plus("x", "y"), 5)).advancedSimplify());
        System.out.println("-----");
// (Log(x, y) + Log(x, y)) => (2.0 * Log(x, y))
        System.out.println("Before Simplify:" + new Plus(new Log("x", "y"), new Log("x", "y")));
        System.out.println("After Simplify:" + new Plus(new Log("x", "y"), new Log("x", "y")).advancedSimplify());
        System.out.println("-----");
// ((x / y) + (x / y)) => (2.0 * (x / y))
        System.out.println("Before Simplify:" + new Plus(new Div("x", "y"), new Div("x", "y")));
        System.out.println("After Simplify:" + new Plus(new Div("x", "y"), new Div("x", "y")).advancedSimplify());
        System.out.println("-----");
    }

    private void negSimplify() {
// -(-(x)) => x
        System.out.println("Before Simplify:" + new Neg(new Neg("x")));
        System.out.println("After Simplify:" + new Neg(new Neg("x")).advancedSimplify());
        System.out.println("-----");
// -(-((x + y))) => (x + y)
        System.out.println("Before Simplify:" + new Neg(new Neg(new Plus("x", "y"))));
        System.out.println("After Simplify:" + new Neg(new Neg(new Plus("x", "y"))).advancedSimplify());
        System.out.println("-----");
    }

    private void minusSimplify() {
        System.out.println("Minus simplify examples:");
// ((x + y) - (y + x)) => 0.0
        System.out.println("Before Simplify:" + new Minus(new Plus("x", "y"), new Plus("y", "x")));
        System.out.println("After Simplify:" + new Minus(new Plus("x", "y"), new Plus("y", "x")).advancedSimplify());
        System.out.println("-----");
    }
    /**
     * divSimplify function.
     * prints div simplify examples.
     */
    private void divSimplify() {
        System.out.println("Div simplify examples:");
// ((5.0 + -(5.0)) / (y + x)) => 0.0
        System.out.println("Before Simplify:" + new Div(new Plus(5, new Neg(5)), new Plus("y", "x")));
        System.out.println("After Simplify:" + new Div(new Plus(5, new Neg(5)), new Plus("y", "x")).advancedSimplify());
        System.out.println("-----");
    }
}