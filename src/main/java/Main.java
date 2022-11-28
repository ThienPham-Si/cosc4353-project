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
                            "5. Sets\n"  +
                            "6. Quit"
            );
            System.out.print("Enter your choice: \n");
            choice = sc.nextInt();
            if( choice != 6) {
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
                    Matrix userMatrix = new Matrix(readMatrixByUser());

                    while (true){
                        exit = false;
                        System.out.print("What operation do you want?\n");
                        String operation = sc.next();
                        switch (operation) {
                            case "*" -> {
                                System.out.print("Enter the 2nd matrix\n");
                                try {
                                    Matrix secondMatrix = new Matrix(readMatrixByUser());
                                    System.out.print(userMatrix.multiplyMatrix(secondMatrix));
                                    userMatrix = userMatrix.multiplyMatrix(secondMatrix);
                                } catch (Exception e) {
                                    System.out.print(e);
                                }
                                break;
                            }
                            case "+" -> {
                                System.out.print("Enter the 2nd matrix\n");
                                try {
                                    Matrix secondMatrix = new Matrix(readMatrixByUser());
                                    System.out.print(userMatrix.addMatrix(secondMatrix));
                                    userMatrix = userMatrix.addMatrix(secondMatrix);
                                } catch (Exception e) {
                                    System.out.print(e);
                                }
                                break;
                            }
                            case "t" -> {
                                System.out.print(userMatrix.tranpose());
                                userMatrix = userMatrix.tranpose();
                                break;
                            }
                            case "p" ->{
                                userMatrix.printMatrix();
                                break;
                            }
                            case "eigValue" -> {
                                userMatrix.eigenValues();
                                break;
                            }
                            case "eigVector" -> {
                                userMatrix.eigenVectors();
                                break;
                            }
                            default -> {
                                exit = true;
                                break;
                            }
                        }
                        if(exit){
                            break;
                        }
                    }
                }

                if (choice==5){
                    setFunction(sc);
                }

            }
        }while(choice != 6);

    }

    public static void setFunction(Scanner scanner){
        Map<String, Sets> sets = new HashMap<>();
        boolean exit;
        while (true){
            System.out.print("Enter the set name\n");
            String setName = scanner.next();
            if("exit".equalsIgnoreCase(setName)){
                break;
            }
            System.out.print("Enter the set elements\n");
            Sets userSet = getSet(scanner);
            sets.put(setName, userSet);
        }



        while (true) {
            exit = false;
            System.out.print("What set do you want?\n");
            String setName = scanner.next();
            if("exit".equalsIgnoreCase(setName)){
                break;
            }
            Sets userSet = sets.get(setName);

            while(true){
            System.out.print(setName + " - What operation do you want?\n");
            String operation = scanner.next();
            switch (operation) {
                case "add" -> {
                    System.out.print("Enter the number:\n");
                    int userInput = scanner.nextInt();
                    userSet.add(userInput);
                    break;
                }
                case "p" -> {
                    userSet.printSet();
                }
                case "subset" -> {
                    System.out.print("Enter the 2nd set name:\n");
                    String secondSetName = scanner.next();
                    Sets secondSet = sets.get(secondSetName);
                    System.out.println(setName + " is a subset of " + secondSetName + "? =>"+userSet.isSubset(secondSet));
                }
                case "union" -> {
                    System.out.print("Enter the 2nd set name:\n");
                    String secondSetName = scanner.next();
                    Sets secondSet = sets.get(secondSetName);
                    userSet = userSet.union(secondSet);
                    System.out.println("The union of " + setName + " and " + secondSetName + " is: " + userSet);
                    sets.put(setName, userSet);
                    break;
                }
                case "intersection" -> {
                    System.out.print("Enter the 2nd set name:\n");
                    String secondSetName = scanner.next();
                    Sets secondSet = sets.get(secondSetName);
                    userSet = userSet.intersection(secondSet);
                    System.out.println("The intersection of " + setName + " and " + secondSetName + " is: " + userSet);
                    sets.put(setName, userSet);
                    break;
                }
                case "difference" -> {
                    System.out.print("Enter the 2nd set name:\n");
                    String secondSetName = scanner.next();
                    Sets secondSet = sets.get(secondSetName);
                    userSet = userSet.difference(secondSet);
                    System.out.println("The difference of " + setName + " and " + secondSetName + " is: " + userSet);
                    sets.put(setName, userSet);
                    break;
                }
                case "symmetricDifference" -> {
                    System.out.print("Enter the 2nd set name:\n");
                    String secondSetName = scanner.next();
                    Sets secondSet = sets.get(secondSetName);
                    userSet = userSet.symmetricDifference(secondSet);
                    System.out.println("The symmetric difference of " + setName + " and " + secondSetName + " is: " + userSet);
                    sets.put(setName, userSet);
                    break;
                }
                case "cartesianProduct" -> {
                    System.out.print("Enter the 2nd set name:\n");
                    String secondSetName = scanner.next();
                    Sets secondSet = sets.get(secondSetName);
                    userSet = userSet.cartesianProduct(secondSet);
                    System.out.println("The cartesian product of " + setName + " and " + secondSetName + " is: " + userSet);
                    sets.put(setName, userSet);
                    break;
                }
                case "showall" -> {
                    for (String name: sets.keySet()) {
                        String key = name.toString();
                        System.out.println(key);
                        Sets value = sets.get(name);
                        value.printSet();
                    }

                }
                case "changeSet" -> {
                    exit = true;
                    break;
                }
                default -> {
                    break;
                }
            }
            if(exit){
                break;
            }}
        }
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

    public static Sets getSet(Scanner scanner){
        Sets returnSet = new Sets();
        System.out.println("Enter your sets, type `!` when you're finished");
        scanner.useDelimiter("");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                returnSet.add(scanner.nextInt());
            } else {
                String s1 = scanner.next();
                if ("!".equalsIgnoreCase(s1)) {
                    break;
                }
            }
        }
        scanner.useDelimiter("\n");
        returnSet.printSet();
        return returnSet;
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

