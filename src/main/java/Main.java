import org.matheclipse.core.eval.ExprEvaluator;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.parser.client.SyntaxError;
import org.matheclipse.parser.client.math.MathException;
import simplification.*;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int choice;
        boolean exit;

        do {
            System.out.println(
                    "" +
                            "\tMath Operations in Java\n"
            );

            System.out.println(
                    "Choose the type of problem:\n" +
                            "1. Basic Operations\n" +
                            "2. Simplify\n" +
                            "3. Solve/Expand\n" +
                            "4. Matrix\n" +
                            "5. Quit"
            );
            System.out.print("Enter your choice: \n");
            choice = sc.nextInt();
            if( choice != 5) {
                if (choice == 1) {
                    System.out.print("Enter your expression \n");
                    while (true){

                        String userInput = sc.next();
                        if("exit".equalsIgnoreCase(userInput)) {
                            break;
                        }
                        Expr ex1 = new Expr(userInput);
                        System.out.println(ex1.getExpressionString() + " = " + ex1.eval());
                    }
                }
                if (choice==2){
                    simplify(sc);
                }
                if (choice==3) {
                    expand(sc);
                }
                if (choice == 4) {
                    System.out.print("How many Matrices?\n");
                    int nMatrices = sc.nextInt();
                    Matrix[] arrayMatrices = new Matrix[nMatrices];

                    for (int i = 1; i <= nMatrices; i++) {
                        System.out.print("Matrix " + i + "\n");
                        Matrix matrix = new Matrix(readMatrixByUser());
                        arrayMatrices[i-1] = matrix;
                    }

                    while (true){
                        exit = false;

                        int pickedMatrix;
                        if (nMatrices == 1){
                            pickedMatrix = 0;
                        } else {
                            System.out.print("Which matrices you want to pick?\n");
                            if (sc.hasNextInt()) {
                                pickedMatrix = sc.nextInt() - 1;
                            } else {
                                break;
                            }
                        }

                        System.out.print("What operation do you want?\n");
                        String operation = sc.next();
                        switch (operation) {
                            case "*":
                                System.out.print("Pick the 2nd matrix\n");
                                try{
                                    int secondMatrix = sc.nextInt() - 1;
                                    System.out.print(arrayMatrices[pickedMatrix].multiplyMatrix(arrayMatrices[secondMatrix]));
                                    arrayMatrices[pickedMatrix]=arrayMatrices[pickedMatrix].multiplyMatrix(arrayMatrices[secondMatrix]);
                                } catch(Exception e) {
                                    System.out.print("Matrix not exist\n");
                                }
                                break;
                            case "t":
                                System.out.print(arrayMatrices[pickedMatrix].tranpose());
                                arrayMatrices[pickedMatrix] = arrayMatrices[pickedMatrix].tranpose();
                                break;
                            case "p":
                                arrayMatrices[pickedMatrix].printMatrix();
                            default:
                                exit = true;
                                break;
                        }
                        if(exit){
                            break;
                        }
                    }
                }

//                String restart = sc.next();
            }
        }while(choice != 5);

    }
    public static double[][] readMatrixByUser()
    {
        int m, n, i, j;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number "
                + "of rows and cols of the matrix (m*n)");
        m = in.nextInt();
        n = in.nextInt();

        // Declare the matrix
        double first[][] = new double[m][n];

        // Read the matrix values
        System.out.println("Enter the elements of the matrix");
        for (i = 0; i < m; i++)
            for (j = 0; j < n; j++)
                first[i][j] = in.nextDouble();

        return first;

    }

    public static void simplify(Scanner sc) {
        System.out.println("Enter the expression");
        while(true){
        String exp = sc.next();
            if("exit".equalsIgnoreCase(exp)) {
                break;
            }
        exp = exp.replaceAll("\\s", "");
        String[] operators = exp.split("(?<=[-+*/])|(?=[-+*/])");
        Expression[] binaryExpressions = new Expression[operators.length];
        for (int i = 0; i < operators.length; i++) {
            if (i % 2 == 0) {
                String[] part = operators[i].split("(?<=\\d)(?=\\D)");
                int coeff = Integer.parseInt(part[0]);
                String var = part[1];
                binaryExpressions[i] = new Mult(coeff, var);
            }
        }

        for (int i = 1; i < operators.length; i += 2) {
            switch ((operators[i])) {
                case "+" -> System.out.println(new Plus(binaryExpressions[0], binaryExpressions[2]).advancedSimplify());
                case "-" -> System.out.println(new Minus(binaryExpressions[0], binaryExpressions[2]).advancedSimplify());
                case "*" -> System.out.println(new Mult(binaryExpressions[0], binaryExpressions[2]).advancedSimplify());
                case "/" -> System.out.println(new Div(binaryExpressions[0], binaryExpressions[2]).advancedSimplify());
                default -> {
                }
            }
        }
    }}

    public static void expand(Scanner sc) {
        System.out.println("Enter the expression");

        while(true){
            String userInput = sc.next();
            ExprEvaluator util = new ExprEvaluator();
            if("exit".equalsIgnoreCase(userInput)) {
                break;
            }

            try {
                    IExpr result = util.eval(userInput);
                    System.out.println(result.toString());
                } catch (SyntaxError ignored) {
                }


//            String[] inputs = userInput.split("\\(", 2);
//            String exp = removeLastChar(inputs[1]);
//            switch (inputs[0]){
//                case "solve" -> {
//                    try {
//                        IExpr result = util.eval(exp);
//                        System.out.println(result.toString());
//                    } catch (SyntaxError e) {
//                        System.out.println(e);
//                    }
//                }
//                case "expand" ->{
//                    try {
//                        IExpr result = util.eval("ExpandAll("+exp+")");
//                        System.out.println(result.toString());
//                    } catch (SyntaxError e) {
//                        System.out.println(e);
//                    }
//                }

            }
        }
        static String removeLastChar(String s)
        {
            return s.substring(0, s.length() - 1);
        }
        }

