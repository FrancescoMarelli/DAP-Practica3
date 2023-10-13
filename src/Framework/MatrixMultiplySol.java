package Framework;

import java.util.ArrayList;

public class MatrixMultiplySol implements Solution{
    ArrayList<ArrayList<Integer>> matrixC;

    public MatrixMultiplySol(ArrayList<ArrayList<Integer>> matrixC) {
        this.matrixC = matrixC;
    }
    public ArrayList<ArrayList<Integer>> getMatrixSol() {
        return matrixC;
    }
    public String toString() {
        return "Matrix C: " + matrixC.toString();
    }

}
