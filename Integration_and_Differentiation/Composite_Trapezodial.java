public class Composite_Trapezodial {
    public static void main(String[] args){
        double n2 = integrate(2, 8, 2);
        double n4 = integrate(2, 8, 4);
        double n6 = integrate(2, 8, 6);

        System.out.println(n2);
        System.out.println(n4);
        System.out.println(n6);
    }

    public static double integrate(double a, double b, int n){
        double h = (b -  a) / n;
        double[] x = new double[n+1];
        x[0] = a;
        for(int i = 1; i<x.length; i++){
            x[i] = x[i-1] + h;
        }

        double sum = 0;
        for(int i = 0; i<x.length; i++){
            if(i == 0 || i == x.length - 1){ // ตัวแรก หรือ ตัวท้าย
                sum += (4*Math.pow(x[i],5)) - (3*Math.pow(x[i],4)) + Math.pow(x[i],3) - 6*x[i] + 2;
            }
            else{
                sum += 2*((4*Math.pow(x[i],5)) - (3*Math.pow(x[i],4)) + Math.pow(x[i],3) - 6*x[i] + 2);
            }
        }

        sum *= (h/2);

        double y = ((4*Math.pow(x[0],6)/6) - (3*Math.pow(x[0],5)/5) + (1*Math.pow(x[0],4)/4) - (6*Math.pow(x[0],2)/2) + (2*Math.pow(x[0],1)/1));
        double y1 = ((4*Math.pow(x[x.length-1],6)/6) - (3*Math.pow(x[x.length-1],5)/5) + (1*Math.pow(x[x.length-1],4)/4) - (6*Math.pow(x[x.length-1],2)/2) + (2*Math.pow(x[x.length-1],1)/1));

        double i_r = y1 - y;

        double error = (i_r - sum) / i_r * 100;

        return error;
    }

}
