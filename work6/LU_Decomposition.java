// package work6;

class Decompos{
    public void print(double[][] a, double[][] b, double[] c){
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a[i].length; j++){
                System.out.print(String.format("%.3f", a[i][j])+" ");
            }
            System.out.println();
        }

        System.out.println();

        for(int i = 0; i<b.length; i++){
            for(int j = 0; j<b[i].length; j++){
                System.out.print(String.format("%.3f", b[i][j])+" ");

            }
            System.out.println();
        }
        System.out.println();

        for(int i = 0; i<a.length; i++){
            System.out.print(String.format("%.3f", c[i])+" ");
        }
        System.out.println();
    }

    public void Decompose(double[][] a, double[]b){
        int n = a.length;
        double[][] l = new double[n][n];
        double[][] u = new double[n][n];
        int j,s,m;

        for(int i = 0; i<n; i++){
            for(j = 0; j<n; j++){
                u[i][i] = 1;
            }
        }

        for(int i = 0; i<n; i++){
            for(j = 0; j<n; j++){
                if(i < j){
                    double x = a[i][j];
                    for(s = 0; s<n; s++){
                        if(i != s){
                            x -= l[i][s]*u[s][j];
                        }
                    }
                    u[i][j] = x / l[i][i];
                }
                else{
                    double sum = 0;
                    for(s = 0; s<n; s++){
                        if(s != j){
                            sum += l[i][s]*u[s][j];
                        }
                    }
                     l[i][j] = a[i][j] - sum;
                }
            }
        }

        double[] solution = new double[n];
        for(int i = 0; i<n; i++){
            solution[i] = b[i];
            for(j = 0; j<i; j++){
                solution[i] -= solution[j]*l[i][j];
            }
            solution[i] /= l[i][i];
        }
        double[] x = new double[n];
        for(int i = n-1; i>= 0; i--){
            x[i] = solution[i];
            for(j = i+1; j<n; j++){
                x[i] -= x[j]*u[i][j];
            }
            x[i] /= u[i][i];
        }

       
        print(l, u, x);
    }
}


public class LU_Decomposition {
    public static void main(String[] args){
        Decompos d = new Decompos();
        double[][] a = {{-2,3,1},{3,4,-5},{1,-2,1}};
        double[] b = {9,0,-4};
        d.Decompose(a,b);
    }
}
