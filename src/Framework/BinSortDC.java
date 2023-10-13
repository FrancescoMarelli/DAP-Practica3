package Framework;
import java.util.ArrayList;



public class BinSortDC extends DivConqTemplate{
    private final int LEFT = 0;
    private final int RIGHT = 1;

    protected boolean isSimple(Problem p) {
        return ((BinSortProb) p).getDisorderedArr().size() == 1;
    }

    protected Solution simplySolve(Problem p) {
        return new BinSortSol(((BinSortProb) p).getDisorderedArr());
    }

    @Override
    protected Problem[] decompose(Problem p) {
        BinSortProb bsp = (BinSortProb) p;
        ArrayList<Integer> disorderedArr = bsp.getDisorderedArr();
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int mid = disorderedArr.size() / 2;

        for(int i = 0; i < mid; i++)
            left.add(disorderedArr.get(i));
        for(int i = mid; i < disorderedArr.size(); i++)
            right.add(disorderedArr.get(i));

        Problem[] pp = new Problem[2];
        pp[LEFT] = new BinSortProb(left);
        pp[RIGHT] = new BinSortProb(right);
        return pp;
    }

    protected Solution combine(Problem p, Solution[] ss) {
        BinSortProb bsp = (BinSortProb) p;
        ArrayList<Integer> disorderedArr = bsp.getDisorderedArr();
        ArrayList<Integer> orderedArr = new ArrayList<Integer>();
        BinSortSol left = (BinSortSol) ss[LEFT];
        BinSortSol right = (BinSortSol) ss[RIGHT];
        ArrayList<Integer> leftArr = left.getOrderedArr();
        ArrayList<Integer> rightArr = right.getOrderedArr();

        int i = 0;
        int j = 0;
        while(i < leftArr.size() && j < rightArr.size()) {
            if(leftArr.get(i) < rightArr.get(j)) {
                orderedArr.add(leftArr.get(i));
                i++;
            } else {
                orderedArr.add(rightArr.get(j));
                j++;
            }
        }
        while(i < leftArr.size()) {
            orderedArr.add(leftArr.get(i));
            i++;
        }
        while(j < rightArr.size()) {
            orderedArr.add(rightArr.get(j));
            j++;
        }
        return new BinSortSol(orderedArr);
    }
}
