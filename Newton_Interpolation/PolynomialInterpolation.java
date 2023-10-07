// package work8;

public class PolynomialInterpolation {
    static double[] x = {0,20000,40000,60000,80000};
    static double[] y = {9.8100,9.7487,9.6879,9.6879,9.5682};
    public static void main(String[] args){
        double[] a = save_c(0, 4);

        double sum = 0;
        double xvalue = 42235;
        double term = 1;

        for(int i = 0; i<a.length; i++){
            if(i == 0){
                sum += a[i];
            }
            else{
                term *= (xvalue - x[i-1]);
                sum += a[i]*term;
            }
        }
        System.out.print("F(42235) = "+String.format("%.6f", sum)+" ");
        
    }

    public static double interpolate(int start, int end){

        if((end - start) == 1 ){
            return (y[end] - y[start]) / (x[end] - x[start]) ;
        }
        else if(end == start){
            return y[end];
        }
        else{
            return (interpolate(start+1, end) - interpolate(start, end-1))/ (x[end] - x[start]);
        }
    }

    public static double[] save_c(int start, int end){
        double[] arr_c = new double[end+1];
        for(int i = start; i<=end; i++){
            arr_c[i] = interpolate(start, i);
        }
        return arr_c;
    }
}
