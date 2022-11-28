import java.util.*;

public class Sets {
    private final Set<Object> hashset = new HashSet<>();

    Sets(){
    }

    public void add(Object obj){
        hashset.add(obj);
    }

    public void remove(Object obj){
        hashset.remove(obj);
    }

    public void clear(){
        hashset.clear();
    }

    public boolean contains(Object obj){
        return hashset.contains(obj);
    }

    public int size(){
        return hashset.size();
    }

    public boolean isEmpty(){
        return hashset.isEmpty();
    }

    public Sets union(Sets set2){
        Sets unionSet = new Sets();
        unionSet.hashset.addAll(this.hashset);
        unionSet.hashset.addAll(set2.hashset);
        return unionSet;
    }

    public Sets intersection(Sets set2){
        Sets intersectionSet = new Sets();
        intersectionSet.hashset.addAll(this.hashset);
        intersectionSet.hashset.retainAll(set2.hashset);
        return intersectionSet;
    }

    public Sets difference(Sets set2){
        Sets differenceSet = new Sets();
        differenceSet.hashset.addAll(this.hashset);
        differenceSet.hashset.removeAll(set2.hashset);
        return differenceSet;
    }

    public Sets symmetricDifference(Sets set2){
        Sets symmetricDifferenceSet = new Sets();
        symmetricDifferenceSet.hashset.addAll(this.hashset);
        symmetricDifferenceSet.hashset.addAll(set2.hashset);
        symmetricDifferenceSet.hashset.removeAll(this.intersection(set2).hashset);
        return symmetricDifferenceSet;
    }

    public boolean isSubset(Sets set2){
        return set2.hashset.containsAll(this.hashset);
    }

    public boolean isSuperset(Sets set2){
        return this.hashset.containsAll(set2.hashset);
    }

    public boolean isProperSubset(Sets set2){
        return this.isSubset(set2) && !this.isSuperset(set2);
    }

    public boolean isDisjoint(Sets set2){
        return this.intersection(set2).hashset.isEmpty();
    }


    @Override
    public String toString() {
        return this.hashset.toString();
    }


}
