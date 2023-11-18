// package work7;

public class Conjugate_Gradient {
    public static void main(String[] args){
        double[][] a = {{5,2,0,0},
                        {2,5,2,0},
                        {0,2,5,2},
                        {0,0,2,5}};
        double[] b = {12,17,14,7};
        double[] X_old = {0,0,0,0};
        double[] X_new = new double[X_old.length];
        double[] R_old =  MatrixMultiplication(a, X_old);
        double[] R_new = new double[R_old.length];
        double[] D_old = new double[R_old.length];
        double lambda;
        double alpha;
        double check;
        int k = 0;

        for(int i = 0; i<R_old.length; i++){
            R_old[i] -= b[i];
            D_old[i] = -(R_old[i]);
        }

        do{
            k++;
            lambda = - (MatrixMultiplication(D_old, R_old) / 
                        MatrixMultiplication(MatrixMultiplication(D_old, a), D_old));

            for(int i = 0; i<X_new.length; i++){    // find {x1new}
                X_new[i] = X_old[i] + lambda*D_old[i];
            }

            for(int i = 0; i<R_new.length; i++){
                R_new[i] = MatrixMultiplication(X_new, a)[i] - b[i];
            }
            
            alpha = MatrixMultiplication(MatrixMultiplication(R_new, a), D_old) / 
                    MatrixMultiplication(MatrixMultiplication(D_old, a), D_old);

            for(int i = 0; i<D_old.length; i++){ // find {D1new}
                D_old[i] = (-R_new[i]) + alpha*D_old[i]; 
            }

            for(int i = 0; i<X_old.length; i++){ // ให้ xเก่า เป็น xใหม่
                X_old[i] = X_new[i];
            }
            
            for(int i = 0; i<R_old.length; i++){ // ให้ Rเก่า เป็น Rใหม่
                R_old[i] = R_new[i];
            }

            check = MatrixMultiplication(R_new, R_new);
            // System.out.println("Error "+""+k+" = "+String.format("%.100f", Math.sqrt(check)));

        }while(Math.sqrt(check) != 0);

        System.out.println(String.format("%.3f", X_new[0])+"\n"+String.format("%.3f", X_new[1])+"\n"
                          +String.format("%.3f", X_new[2])+"\n"+String.format("%.3f", X_new[3])+"\n");
        System.out.println(k);

    }   
    
    public static double[][] MatrixMultiplication(double[][] a, double[][] b){
        int n = a.length;
        int m = b[0].length;
        int sum_loop = b.length;
        double[][] result = new double[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0 ; j<m; j++){
                double sum = 0;
                for(int k = 0; k<sum_loop; k++){
                    sum += a[i][k]*b[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public static double[] MatrixMultiplication(double[][] a, double[] b){
        int n = a.length;
        int m = b.length;
        int sum_loop = b.length;
        double[] result = new double[n];

        for(int i = 0; i<n; i++){
            for(int j = 0 ; j<m; j++){
                double sum = 0;
                for(int k = 0; k<sum_loop; k++){
                    sum += a[i][k]*b[k];
                }
                result[j] = sum;
            }
        }

        return result;
    }

    public static double[] MatrixMultiplication(double[] a, double[][] b){
        int n = a.length;
        int m = b[0].length;
        int sum_loop = b.length;
        double[] result = new double[n];

        for(int i = 0; i<n; i++){
            for(int j = 0 ; j<m; j++){
                double sum = 0;
                for(int k = 0; k<sum_loop; k++){
                    sum += a[k]*b[k][j];
                }
                result[j] = sum;
            }
        }

        return result;
    }

    public static double MatrixMultiplication(double[] a, double[] b){
        int n = a.length;
        double result;
        double sum = 0;

        for(int i = 0; i<n; i++){
            sum += a[i]*b[i];
        }
        result = sum;
        return result;
    }

}
