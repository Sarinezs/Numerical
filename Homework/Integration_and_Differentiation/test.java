public class test{
    public static void main(String[] args){
        double x1 = 2;
        double y1 = ((4*Math.pow(x1,6)/6) - (3*Math.pow(x1,5)/5) + (1*Math.pow(x1,4)/4) - (6*Math.pow(x1,2)/2) + (2*Math.pow(x1,1)/1));
        
        double x2 = 8;
        double y2 = ((4*Math.pow(x2,6)/6) - (3*Math.pow(x2,5)/5) + (1*Math.pow(x2,4)/4) - (6*Math.pow(x2,2)/2) + (2*Math.pow(x2,1)/1));

        double x3 = 5;
        double y0 = ((4*Math.pow(x3,5)/1) - (3*Math.pow(x3,4)/1) + (1*Math.pow(x3,3)/1) - (6*Math.pow(x3,1)/1) + (2*Math.pow(x3,0)/1));

        double exact_integral = y2 - y1;
        // double error = exact_integral - 

        System.out.println(y0);
        System.out.println(y1);
        System.out.println(y2);
        System.out.println(exact_integral);
    }
}