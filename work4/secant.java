// package work4;

public class secant {
    public static void main(String[] args){
        double x0 = 1;
        double x1 = 0;
        double xcheck;
        double x2;
        do {
            xcheck = x1;
            double y0 = Math.sqrt(7) - x0;
            double y1 = Math.sqrt(7) - x1;
            x2 = x0 - (y0*(x0 - x1)) / (y0 - y1);
            x0 = x1;
            x1 = x2;
        } while (Math.abs((x2 - xcheck)/x2)*100 >= 0.000001);
        System.out.println(x2);
    }
}
