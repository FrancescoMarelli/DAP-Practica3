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

        // Crea dos nuevas matrices matrixA y matrixB
        ArrayList<ArrayList<Integer>> matrixA1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> matrixB1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> matrixA2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> matrixB2 = new ArrayList<>();

        for (int i = 0; i < n / 2; i++) {
            matrixA1.add(new ArrayList<>());
            matrixB1.add(new ArrayList<>());
            matrixA2.add(new ArrayList<>());
            matrixB2.add(new ArrayList<>());
            for (int j = 0; j < n / 2; j++) {
                matrixA1.get(i).add(mmp.getMatrixA().get(i).get(j));
                matrixB1.get(i).add(mmp.getMatrixB().get(i).get(j));
                matrixA2.get(i).add(mmp.getMatrixA().get(i + n / 2).get(j));
                matrixB2.get(i).add(mmp.getMatrixB().get(i + n / 2).get(j));
            }
        }
        // Crea dos nuevos problemas
        Problem[] pp = new Problem[2];
        pp[0] = new MatrixMultiplyProb(matrixA1, matrixB1);
        pp[1] = new MatrixMultiplyProb(matrixA2, matrixB2);
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
