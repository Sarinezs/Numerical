import java.util.Scanner;

public class Matrixinverse {

    // ... existing methods ...

    public double[][] matrixInverse(double[][] a) {
        int n = a.length;
        double[][] identity = new double[n][n];
        double[][] augmentedMatrix = new double[n][2 * n];

        // Initialize the identity matrix and create an augmented matrix [A | I]
        for (int i = 0; i < n; i++) {
            identity[i][i] = 1;
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = a[i][j];
                augmentedMatrix[i][j + n] = identity[i][j];
            }
        }

        // Perform Gauss-Jordan elimination on the augmented matrix
        for (int k = 0; k < n; k++) {
            double pivot = augmentedMatrix[k][k];
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[k][j] /= pivot;
            }
            for (int i = 0; i < n; i++) {
                if (i != k) {
                    double factor = augmentedMatrix[i][k];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[i][j] -= factor * augmentedMatrix[k][j];
                    }
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < 2*n; j++) {
        //         System.out.print(String.format("%.2f", augmentedMatrix[i][j]) + " ");
        //     }
        //     System.out.println();
        // }

        // Extract the inverse matrix from the augmented matrix
        double[][] inverse = new double[n][n];
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < n; j++) {
                inverse[k][j] = augmentedMatrix[k][j + n];
            }
        }

        return augmentedMatrix;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrixinverse ge = new Matrixinverse();
        double[][] a = {{-2, 3, 1}, {3, 4, -5}, {1, -2, 1}};

        double[][] inverse = ge.matrixInverse(a);
        
        // Print the inverse matrix
        System.out.println("Inverse Matrix:");
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j < inverse[i].length; j++) {
                System.out.print(String.format("%.2f", inverse[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
