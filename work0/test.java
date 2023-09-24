// package work0;

public class test{
    public static void main(String[] args){
        double[][] a = {{-2,3,1},{3,4,-5},{1,-2,1}};
        double[] b = {9,0,-4};
        gaussian(a, b);
    }

    public static void gaussian(double[][] a, double[] b){
        int n = a.length;
        double[][] l = new double[n][n];
        double[][] u = new double[n][n];
        double[] solution = new double[n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                u[i][j] = 1;
            }
        }

       
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                double factor = a[j][i] / a[i][i];
                b[j] -= factor*b[i];
                for(int k = 0; k<n; k++){
                    a[j][k] -= factor*a[i][k];
                }
            }
        }

        for(int i = n-1; i>=0; i--){
            for(int j = i-1; j>=0; j--){
                double factor = a[j][i] / a[i][i];
                b[j] -= factor*b[i];
                for(int k = 0; k<n; k++){
                    a[j][k] -= factor*a[i][k];
                }
            }
        }

        for(int i = n-1; i>=0; i--){
            double pivot = a[i][i];
            b[i] /= pivot;
            for(int j = 0; j<n; j++){
                a[i][j] /= pivot;
            }
        }

        for(int i = n-1; i>=0; i--){
            double sum = 0;
            for(int j = i+1; j<n; j++){
                sum += a[i][j]*solution[j];
            }
            solution[i] = (b[i] - sum) / a[i][i];
            
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(String.format("%.2f", a[i][j])+" ");
            }
            System.out.println(" | "+String.format("%.2f", b[i]));
        }
        System.out.println(String.format("%.2f", solution[0]));
        System.out.println(String.format("%.2f", solution[1]));
        System.out.println(String.format("%.2f", solution[2]));
    }
}