package Framework;

import java.util.ArrayList;

public class BinSortProb implements Problem{
    private final ArrayList<Integer> disorderedArr;

    public BinSortProb(ArrayList<Integer> disorderedArr) {
        this.disorderedArr = disorderedArr;
    }
    public ArrayList<Integer> getDisorderedArr() {
        return disorderedArr;
    }

}
