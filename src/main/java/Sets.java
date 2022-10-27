import java.util.*;

public class Sets {
    private final Set<Object> hashset = new HashSet<>();

    Sets(){
    }

    public void add(Object a){
        hashset.add(a);
    }

    @Override
    public String toString() {
        return this.hashset.toString();
    }


}
