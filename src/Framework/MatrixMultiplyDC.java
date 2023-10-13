package Framework;

import java.util.ArrayList;

public class MatrixMultiplyDC extends DivConqTemplate{

    protected boolean isSimple(Problem p) {
        return ((MatrixMultiplyProb) p).getMatrixA().isEmpty();
    }
    protected Solution simplySolve(Problem p) {
        MatrixMultiplyProb mmp = (MatrixMultiplyProb) p;
        ArrayList<ArrayList<Integer>> matrixA = mmp.getMatrixA();
        if (matrixA.size() == 0) {
            return new MatrixMultiplySol(new ArrayList<ArrayList<Integer>>());
        } else {
            return new MatrixMultiplySol(matrixA);
        }
    }
    protected Problem[] decompose(Problem p) {
        MatrixMultiplyProb mmp = (MatrixMultiplyProb) p;
        int n = mmp.getMatrixA().size();
        ArrayList<ArrayList<Integer>> matrixA = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> matrixB = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> rowA = new ArrayList<Integer>();
        ArrayList<Integer> rowB = new ArrayList<Integer>();
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                rowA.add(mmp.getMatrixA().get(i).get(j));
                rowB.add(mmp.getMatrixB().get(i).get(j));
            }
            matrixA.add(rowA);
            matrixB.add(rowB);
            rowA = new ArrayList<Integer>();
            rowB = new ArrayList<Integer>();
        }
        Problem[] pp = new Problem[2];
        pp[0] = new MatrixMultiplyProb(matrixA, matrixB);
        pp[1] = new MatrixMultiplyProb(matrixA, matrixB);
        return pp;
    }
    protected Solution combine(Problem p, Solution[] ss) {
        MatrixMultiplyProb mmp = (MatrixMultiplyProb) p;
        ArrayList<ArrayList<Integer>> matrixA = mmp.getMatrixA();
        ArrayList<ArrayList<Integer>> matrixB = mmp.getMatrixB();
        ArrayList<ArrayList<Integer>> matrixC = new ArrayList<>();
        ArrayList<Integer> rowC = new ArrayList<Integer>();

        for (ArrayList<Integer> row : matrixA) {
            for (int j = 0; j < matrixB.get(0).size(); j++) {
                int sum = 0;
                for (int k = 0; k < matrixA.get(0).size(); k++) {
                    sum += row.get(k) * matrixB.get(k).get(j);
                }
                rowC.add(sum);
            }
            matrixC.add(rowC);
            rowC = new ArrayList<>();
        }
        return new MatrixMultiplySol(matrixC);
    }

}
