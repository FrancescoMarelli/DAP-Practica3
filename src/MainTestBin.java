import Framework.*;

import java.util.ArrayList;

public class MainTestBin {
    public static void main(String[] args) {
        ArrayList<Integer> disorderedArr = new ArrayList<Integer>();
        disorderedArr.add(9);
        disorderedArr.add(8);
        disorderedArr.add(10);
        disorderedArr.add(7);
        disorderedArr.add(1);
        disorderedArr.add(2);
        BinSortProb p = new BinSortProb(disorderedArr);
        System.out.println("Disordered problem " + p.getDisorderedArr());
        BinSortSol s = new BinSortSol(disorderedArr);
        BinSortDC dc = new BinSortDC();
        Solution sol = dc.solve(p);
        System.out.println(sol);
    }
}