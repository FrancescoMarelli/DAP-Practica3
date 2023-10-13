package Framework;

import java.util.ArrayList;

public class BinSortSol implements Solution{
    private final ArrayList<Integer> orderedArr;

    public BinSortSol(ArrayList<Integer> orderedArr) {
        this.orderedArr = orderedArr;
    }
    public ArrayList<Integer> getOrderedArr() {
        return orderedArr;
    }
    public String toString() {
        return "Binary Sorting: " + orderedArr.toString();
    }
}
