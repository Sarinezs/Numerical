
public class Quadratic_interpolation {
    static double[] x = {0,20000,40000,60000,80000};
    static double[] y = {9.8100,9.7487,9.6879,9.6879,9.5682};
    public static void main(String[] args){
        double[] l = interpolate(0, 2, 4, 42235);
        double sum = l[0] + l[1] + l[2];
        System.out.println(String.format("%.4f", (sum)));
    }

    public static double[] interpolate(int p1, int p2, int p3, int xvalue){
        double[] l = new double[3];

        l[0] = ((x[p2] - xvalue) / (x[p2] - x[p1]) * (x[p3] - xvalue) / (x[p3] - x[p1])) * y[p1];
        l[1] = ((x[p1] - xvalue) / (x[p1] - x[p2]) * (x[p3] - xvalue) / (x[p3] - x[p2])) * y[p2];
        l[2] = ((x[p1] - xvalue) / (x[p1] - x[p3]) * (x[p2] - xvalue) / (x[p2] - x[p3])) * y[p3];

        return l;
    }
}
