// package Differentiation;

public class Second_Divided_Differences {
    public static void main(String[] args){
        double xstart = -2.5;
        double h = 0.1;

        double[] x = {-2.8,-2.7,-2.6,-2.5,-2.4,-2.3,-2.2};
        double[] fx = new double[7];
        for(int i = 0; i<fx.length; i++){
            fx[i] = Math.exp(x[i]/3) + Math.pow(x[i], 2);
        }

        

        System.out.println(forward(x, fx, h));
        System.out.println(backward(x, fx, h));
        System.out.println(central(x, fx, h));
    }

    public static double forward(double[] x, double[] fx, double h){
        return (-fx[6] + 4*fx[5] - 5*fx[4] + 2*fx[3]) / (h*h);
    }

    public static double backward(double[] x, double[] fx, double h){
        return (2*fx[3] - 5*fx[2] + 4*fx[1] - fx[0]) / (h*h);
    }

    public static double central(double[] x, double[] fx, double h){
        return (-fx[5] + 16*fx[4] - 30*fx[3] + 16*fx[2] - fx[1]) / (12*h*h);
    }
}
