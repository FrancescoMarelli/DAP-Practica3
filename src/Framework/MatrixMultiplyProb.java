package Framework;

import java.util.ArrayList;

public class MatrixMultiplyProb implements Problem {
    ArrayList<ArrayList<Integer>> matrixA;
    ArrayList<ArrayList<Integer>> matrixB;
    public MatrixMultiplyProb(ArrayList<ArrayList<Integer>> matrixA, ArrayList<ArrayList<Integer>> matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
    }
    public ArrayList<ArrayList<Integer>> getMatrixA() {
        return matrixA;
    }

    public ArrayList<ArrayList<Integer>> getMatrixB() {
        return matrixB;
    }

}
