package Lagrange_Interpolation;
public class Polynomial_Interpolation {
    static double[] x = {0,20000,40000,60000,80000};
    static double[] y = {9.8100,9.7487,9.6879,9.6879,9.5682};
    public static void main(String[] args){
        interpolate(0, 4, 42235);

    }

    public static void interpolate(int start, int end, int xvalue){
        int n = (end - start);
        double[] l = new double[n+1];

        for(int i = start; i<=n; i++){
            double term = 1;
            for(int j = start; j<=n; j++){
                if(j == i){
                    continue;
                }
                term *= (x[j] - xvalue) / (x[j] - x[i]);
            }
            l[i] = term * y[i];
        }
        double solution = 0;
        for(int i = 0; i<=n; i++){
            solution += l[i];
        }

        System.out.println(String.format("%.4f", solution));
    }
}
