package experimental;

import java.util.Scanner;
import java.util.Random;

public class BasicOperations {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int choice, numProblems, maxOperand, response, num1, num2, correct = 0, answer = 0;
        double average;

        do {
            System.out.println(
                    "" +
                            "\tBasic Operations in Java\n"
            );

            System.out.println(
                    "Choose the type of problem:\n" +
                            "1. Addition\n" +
                            "2. Multiplication\n" +
                            "3. Mixed\n" +
                            "4. Quit"
            );
            System.out.print("Enter your choice: \n");
            choice = sc.nextInt();
            if( choice != 4){
                System.out.print("How many problems? \n");
                numProblems = sc.nextInt();
                System.out.print("Largest operand? \n\n");
                maxOperand = sc.nextInt();
                // Each Problem will run this Sequence
                for (int i = 0; i < numProblems; i++) {
                    num1 = rnd.nextInt(maxOperand);
                    num2 = rnd.nextInt(maxOperand);
                    response = rnd.nextInt(maxOperand); // Random Answers
                    // Addition
                    if (choice == 1) {
                        System.out.printf("%d + %d = ?\n", num1, num2);
                        answer = num1 + num2;
                    }
                    // Multiplication
                    else if (choice == 2) {
                        System.out.printf("%d * %d = ?\n", num1, num2);
                        answer = num1 * num2;
                    }
                    if( response == answer ) {
                        System.out.println("Correct!");
                    }
                    else {
                        System.out.printf("Incorrect. The answer is %d.\n", answer);
                    }
                }
                // Print Summary Details
                System.out.printf("You answered %d out of %d correctly", correct, numProblems);
                average = (double) correct/numProblems * 100;
                System.out.printf("Your average was %f ", average);
            }
        }while (choice != 4);
    }
}