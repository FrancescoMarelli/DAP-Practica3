import Framework.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final int BINSORT = 1;
    static final int MATRIXMULTIPLY = 2;
    public static void main(String[] args) {
        System.out.println("Benvienido en el programa del método Plantilla");
        System.out.println("Con que algoritmo desea trabajar?");
        System.out.println("1. BinSort");
        System.out.println("2. MatrixMultiply");
        System.out.println("Marqué la opcion 1 o 2");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        Problem p = null;
        Solution s = null;
        DivConqTemplate dc = null;

        switch (opcion) {
            case BINSORT: {
                System.out.println("Ingrese el tamaño del vector");
                int n = sc.nextInt();
                ArrayList<Integer> disorderedArr = new ArrayList<Integer>();
                for (int i = 0; i < n; i++) {
                    System.out.println("Ingrese el elemento " + (i + 1));
                    disorderedArr.add(sc.nextInt());
                }
                p = new BinSortProb(disorderedArr);
                dc = new BinSortDC();
                ArrayList<Integer> orderedArr = ((BinSortSol) dc.solve(p) ).getOrderedArr();
                s = new BinSortSol(orderedArr);
                System.out.println(s);
                break;
            }
            case MATRIXMULTIPLY: {
                ArrayList<ArrayList<Integer>> matrixA = new BuildMatrix().BuildMatrix();
                ArrayList<ArrayList<Integer>> matrixB = new BuildMatrix().BuildMatrix();
                int n = matrixA.get(0).size();
                int m = matrixB.size();

                if( n != m){
                    System.out.println("\nEl numero de columnas de la matriz A debe ser igual al numero de filas de la matriz B\n");
                    System.exit(0);
                }
                p = new MatrixMultiplyProb(matrixA, matrixB);
                dc = new MatrixMultiplyDC();
                ArrayList<ArrayList<Integer>> matrixC = ((MatrixMultiplySol) dc.solve(p)).getMatrixSol();
                s = new MatrixMultiplySol(matrixC);
                System.out.println(s);
            break;
            }
            default:
                System.out.println("Opcion no valida");
        }

    }
}
