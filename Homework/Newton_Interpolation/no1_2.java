public class no1_2 {
    static double[] x = {0,20000,40000,60000,80000};
    static double[] y = {9.8100,9.7487,9.6879,9.6879,9.5682};
    public static void main(String[] args){
        double c0 = y[0];
        double c1 = (y[2] - y[0]) / (x[2] - x[0]);
        double c2 = (((y[4] - y[2])/(x[4]-x[2])) - c1) / (x[4] - x[0]);
        double fx = c0 + c1*(42235 - x[0]) + c2*(42235 - x[0])*(42235 - x[2]);
        System.out.println("f(42235) = "+String.format("%.4f", fx));
    }
}
