/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.*;
import java.lang.*;

class Rectangle {
     
    private int length;
    private int breadth;
     
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getBreadth() {
        return breadth;
    }
    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }  
    public int getArea() {
        return this.length * this.breadth;
    }
}
class Square extends Rectangle {
     
    @Override
    public void setBreadth(int breadth) {
        super.setBreadth(breadth);
        super.setLength(breadth);
    }
    @Override
    public void setLength(int length) {
        super.setLength(length);
        super.setBreadth(length);
    }
}
/**
 * The class demonstrates the Liskov Substitution Principle (LSP)
 *
 * As per the principle, the functions that use references to the base classes must be able to use objects of derived class without knowing it.
 * Thus, in the example shown below, the function calculateArea which uses the reference of "Rectangle" should be able to use the objects of
 * derived class such as Square and fulfill the requirement posed by Rectangle definition.

 */
class LSPDemo {
    /**
     * guidelines for rectangle conversions
     * 1. Length must always be equal to the length passed as the input to method, setLength
     * 2. Breadth must always be equal to the breadth passed as input to method, setBreadth
     * 3. Area must always be equal to product of length and breadth
     *
     * In case, we try to establish ISA relationship between Square and Rectangle such that we call "Square is a Rectangle",
     * below code would start behaving unexpectedly if an instance of Square is passed
     * Assertion error will be thrown in case of check for area and check for breadth, although the program will terminate as
     * the assertion error is thrown due to failure of Area check.
     *  
     * @param r Instance of Rectangle
     */
    public void calculateArea(Rectangle r) {
        r.setBreadth(2);
        r.setLength(3);
        //
        // Assert Area
        //
        // From the code, the expected behavior is that
        // the area of the rectangle is equal to 6
        //
        assert r.getArea() == 6 : printError("area", r);
        //
        // Assert Length &amp; Breadth
        //
        // From the code, the expected behavior is that
        // the length should always be equal to 3 and
        // the breadth should always be equal to 2
        //
        assert r.getLength() == 3 : printError("length", r);
        assert r.getBreadth() == 2 : printError("breadth", r);
    }
     
    private String printError(String errorIdentifer, Rectangle r) {
        return "Unexpected value of " + errorIdentifer + "  for instance of " + r.getClass().getName();
    }
    
    public class ReplaceExample1{  
        public static void main(String args[]){  
        String s1="2x + 3x * 2y";  
        String replaceString=s1.replace('x','a');//replaces all occurrences of 'x' to 'a'  
        System.out.println(replaceString);  
        }
    }  
    public class JavaReplaceCharExample{
        public static void main(String[] args){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the equation you would like to solve");
            String str = input.nextLine();
            System.out.println("Enter the character to replace in the equation");
            char ch = input.next().charAt(0);
            System.out.println("Enter the character to be replaced with in the equation");
            char newCh = input.next().charAt(0);
            String newStr = str.replace(ch, newCh);
            //displaying new string after applying replace method
            System.out.println(newStr);
    }
}
    public static void main(String[] args) {
        LSPDemo lsp = new LSPDemo();
        lsp.calculateArea(new Rectangle());
        lsp.calculateArea(new Square());
    }
    
    
}