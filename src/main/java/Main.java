import java.util.*;

public class Main {
    public static double[][] readMatrixByUser()
    {
        int m, n, i, j;
        Scanner in = null;
        in = new Scanner(System.in);
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
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Random rnd = new Random();
        int choice;
        double average;

        do {
            System.out.println(
                    "" +
                            "\tMath Operations in Java\n"
            );

            System.out.println(
                    "Choose the type of problem:\n" +
                            "1. Basic Operations\n" +
                            "2. Solve\n" +
                            "3. Matrix\n" +
                            "4. Quit"
            );
            System.out.print("Enter your choice: \n");
            choice = sc.nextInt();
            if( choice != 4) {
                if (choice == 1) {
                    System.out.print("Enter your expression \n");
                    Expression ex1 = new Expression(sc.next());
                    System.out.println(ex1.getExpressionString() + " = " + ex1.eval());
                }
                if (choice == 3) {
                    System.out.print("How many Matrices?\n");
                    int nMatrices = sc.nextInt();
                    Matrix arrayMatrices[] = new Matrix[nMatrices];

                    for (int i = 1; i <= nMatrices; i++) {
                        System.out.print("Matrix " + i + "\n");
                        Matrix matrix = new Matrix(readMatrixByUser());
                        arrayMatrices[i] = matrix;
                    }


                    System.out.print("What operation do you want?\n");
                    String operation = sc.next();
                    switch (operation) {
                        case "*":
                            System.out.print(arrayMatrices[0].multiplyMatrix(arrayMatrices[1]));
                            break;
                        case "t":
                            System.out.print(arrayMatrices[0].tranpose());
                            break;
                        default:
                    }
                }

                String restart = sc.next();
            }
        }while(choice != 4);

    }

}

