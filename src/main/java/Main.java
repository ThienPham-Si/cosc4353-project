import simplification.Div;
import simplification.Minus;
import simplification.Mult;
import simplification.Plus;

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
                            "3. Matrix\n" +
                            "4. Set\n" +
                            "5. Quit"
            );
            System.out.print("Enter your choice: \n");
            choice = sc.nextInt();
            if( choice != 4) {
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
                if (choice == 3) {
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

                String restart = sc.next();
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
        String exp = sc.next();

        // example: 2x, +, 3x
        exp = exp.replaceAll("\\s", "");
        String[] operators = exp.split("(?<=[-+*/])|(?=[-+*/])");
        Mult[] binaryExpressions = new Mult[operators.length];
        for (int i = 0; i < operators.length; i++) {
            if (i % 2 == 0) {
                String[] part = operators[i].split("(?<=\\d)(?=\\D)");
                int coeff = Integer.parseInt(part[0]);
                String var = part[1];
                binaryExpressions[i] = new Mult(coeff, var);
            } else {
                operators[i] = operators[i];
            }
        }

        switch ((operators[1])) {
            case "+":
                System.out.println(new Plus((Mult) binaryExpressions[0], (Mult) binaryExpressions[2]).advancedSimplify());
                break;
            case "-":
                System.out.println(new Minus((Mult) binaryExpressions[0], (Mult) binaryExpressions[2]).advancedSimplify());
                break;
            case "*":
                System.out.println(new Mult((Mult) binaryExpressions[0], (Mult) binaryExpressions[2]).advancedSimplify());
                break;
            case "/":
                System.out.println(new Div((Mult) binaryExpressions[0], (Mult) binaryExpressions[2]).advancedSimplify());
                break;
            default:
                break;
        }
    }
}

