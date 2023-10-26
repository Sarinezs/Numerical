// package Differentiation;

public class First_Divided_Differences {
    public static void main(String[] args){
        int xstart = 2;
        double h = 0.25;

        double[] x = {1.75,2,2.25};
        double[] fx = new double[3];
        for(int i = 0; i<fx.length; i++){
            fx[i] = Math.exp(x[i]);
        }

        System.out.println(forward(x, fx, h, xstart));
        System.out.println(backward(x, fx, h, xstart));
        System.out.println(central(x, fx, h, xstart));
    }

    public static double forward(double[] x, double[] fx, double h, int xstart){
        return (fx[2] - fx[1]) / h;
    }

    public static double backward(double[] x, double[] fx, double h, int xstart){
        return (fx[1] - fx[0]) / h;
    }

    public static double central(double[] x, double[] fx, double h, int xstart){
        return (fx[2] - fx[0]) / (2*h);
    }
}
