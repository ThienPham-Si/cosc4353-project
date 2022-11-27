import simplification.Pow;
import simplification.SimplificationDemo;

public class testing {

    public static void main(String[] args) {

        SimplificationDemo examples = new SimplificationDemo();
        examples.powerSimplify();

    }
    public void powerSimplify() {
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
}
