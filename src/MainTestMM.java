import Framework.MatrixMultiplyDC;
import Framework.MatrixMultiplyProb;
import Framework.MatrixMultiplySol;
import Framework.Solution;

import java.util.ArrayList;

public class MainTestMM {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrixA = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> matrixB = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> rowA1 = new ArrayList<Integer>();
        ArrayList<Integer> rowA2 = new ArrayList<Integer>();
        ArrayList<Integer> rowA3 = new ArrayList<Integer>();
        ArrayList<Integer> rowB1 = new ArrayList<Integer>();
        ArrayList<Integer> rowB2 = new ArrayList<Integer>();
        ArrayList<Integer> rowB3 = new ArrayList<Integer>();
        rowA1.add(1);
        rowA1.add(2);
        rowA1.add(3);
        rowA2.add(4);
        rowA2.add(5);
        rowA2.add(6);
        rowA3.add(7);
        rowA3.add(8);
        rowA3.add(9);
        rowB1.add(1);
        rowB1.add(2);
        rowB1.add(3);
        rowB2.add(4);
        rowB2.add(5);
        rowB2.add(6);
        rowB3.add(7);
        rowB3.add(8);
        rowB3.add(9);
        matrixA.add(rowA1);
        matrixA.add(rowA2);
        matrixA.add(rowA3);
        matrixB.add(rowB1);
        matrixB.add(rowB2);
        matrixB.add(rowB3);
        MatrixMultiplyProb p = new MatrixMultiplyProb(matrixA, matrixB);
        System.out.println("Matrix A: " + p.getMatrixA());
        System.out.println("Matrix B: " + p.getMatrixB());
        MatrixMultiplySol s = new MatrixMultiplySol(matrixA);
        MatrixMultiplySol s2 = new MatrixMultiplySol(matrixB);
        MatrixMultiplyDC dc = new MatrixMultiplyDC();
        Solution sol = dc.solve(p);
        System.out.println(sol);
    }
}
