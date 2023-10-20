package Framework;

import java.util.ArrayList;
import java.util.Scanner;

public class BuildMatrix {
    public ArrayList<ArrayList<Integer>>  BuildMatrix() {
        System.out.println("El numero de columnas de la matriz A debe ser igual al numero de filas de la matriz");
        ArrayList<ArrayList<Integer>> matrixA = new ArrayList<ArrayList<Integer>>();
        //do a for to get two matrixes and get the size of the matrixes
        System.out.println("Ingrese el numero de filas  de la matriz");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Ingrese el numero de columnas de la matriz");
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < m; j++) {
                System.out.println("Ingrese el elemento " + (j + 1) + " de la fila " + (i + 1) + " de la matriz");
                row.add(sc.nextInt());
            }
            matrixA.add(row);
        }
        return matrixA;
    }
}
