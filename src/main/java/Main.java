import java.util.*;

public class Main {
    public static void main(String[] args){

        Symbol x = new Symbol("x");
        System.out.println(x);

        Sets new_set = new Sets();
        new_set.add("hello");
        new_set.add(1);
        new_set.add(1.2);

        System.out.println(new_set);


    }
}
