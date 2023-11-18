public class Single_TrapeZodial {
    public static void main(String[] args){
        double[] a = {2,8};
        double h = (a[a.length - 1] - a[0]);

        
        double sum = 0;
        for(int i = 0; i<a.length; i++){
            double y = (4*Math.pow(a[i],5)) - (3*Math.pow(a[i],4)) + Math.pow(a[i],3) - 6*a[i] + 2;

            sum += y;
        }

        double i = (h/2)*(sum);
        double i_r = integrate(a);
        
        double ans = ((i_r - i) / i_r) * 100;
        System.out.println(ans);
        
    }

    public static double integrate(double[] a){

        double y = ((4*Math.pow(a[0],6)/6) - (3*Math.pow(a[0],5)/5) + (1*Math.pow(a[0],4)/4) - (6*Math.pow(a[0],2)/2) + (2*Math.pow(a[0],1)/1));
        double y1 = ((4*Math.pow(a[1],6)/6) - (3*Math.pow(a[1],5)/5) + (1*Math.pow(a[1],4)/4) - (6*Math.pow(a[1],2)/2) + (2*Math.pow(a[1],1)/1));
        
        
        double sum = y1 - y;

        return sum;
    }
}
