import java.util.*;

public class SlopeOfALine {
    public static void main(String[] args) {

        System.out.println("Welcome to the Slope of a Line Calculator!");

        try {
            Scanner scan = new Scanner(System.in);
            //Prompt user for point values

            //The First Point
            System.out.print("What is the value of the 'x' coordinate of your first point?  ");
            double x1 = scan.nextDouble();

            System.out.print("What is the value of the 'y' coordinate of your first point?  ");
            double y1 = scan.nextDouble();

            //The Second Point
            System.out.print("What is the value of the 'x' coordinate of your second point?  ");
            double x2 = scan.nextDouble();
            System.out.print("What is the value of the 'y' coordinate of your second point?  ");
            double y2 = scan.nextDouble();
            System.out.println("\nCalculating...");

            String answer = "";
            if (x2 - x1 == 0d) {
                answer = "This is a vertical line with no slope, also known as an Infinity Slope or Undefined Slope";
            }
            else {
                double slope = (y2 - y1) / (x2 - x1);
                answer = "The slope of your line is " + slope;
            }

            System.out.println(answer);
            System.out.println("--------------");

            scan.close();
        } catch (InputMismatchException ex) {
            System.err.println("Please provide only numbers (not text). Please restart the program and try again!");
            main(new String[0]);
        }

    }
}