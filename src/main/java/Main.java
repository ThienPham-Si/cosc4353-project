import java.util.*;

public class Main {
    public static void main(String[] args){

        ///////////////////// Symbol
        Symbol x = new Symbol("x", 4);

        ///////////////////// Expression
        // basic calculation
        Expression ex1 = new Expression("2^(3+3)+2");
        System.out.println(ex1.getExpressionString() + " = " + ex1.eval());

        // power
        ex1.setExpressionString("2^3 + 2");
        System.out.println(ex1.getExpressionString() + " = " + ex1.eval());

        // sin, cos
        ex1.setExpressionString("sin(45) + cos(45)");
        System.out.println(ex1.getExpressionString() + " = " + ex1.eval());

        // relation
        ex1.setExpressionString("3+3 = 7");
        System.out.println(ex1.getExpressionString() + " is " + ex1.eval());

        ///////////////////// Matrix
        // Print matrix
        Matrix matrix1 = new Matrix(new double[][]{{1,2,3}, {4,5,6}, {7,8,9}});

        // Multiply
        Matrix matrix2 = new Matrix(new double[][]{{1,2,3}, {4,5,6}, {7,8,9}});
        System.out.print(matrix1.multiplyMatrix(matrix2));

        // Add
        Matrix matrix3 = new Matrix(new double[][]{{1,2,3}, {4,5,6}, {7,8,9}});
        System.out.print(matrix1.addMatrix(matrix3));

        // Transpose
        System.out.print(matrix1.tranpose());

        // Shape
        System.out.println(matrix1.shape());

        // Mult
        matrix1.mult(2);
        matrix1.printMatrix();
    }

}
