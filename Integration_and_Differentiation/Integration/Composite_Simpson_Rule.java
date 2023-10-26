public class Composite_Simpson_Rule {
    public static void main(String[] args){
        double n2 = integrate(-1, 2, 2);
        double n4 = integrate(-1, 2, 4);
        double n6 = integrate(-1, 2, 6);

        System.out.println(n2);
        System.out.println(n4);
        System.out.println(n6);
    }    

    public static double integrate(double a, double b, int n){
        double h = (b -  a) / n;
        double[] x = new double[n+1];
        x[0] = a;
        // System.out.println(x[0]);
        for(int i = 1; i<x.length; i++){
            x[i] = x[i-1] + h;
            // System.out.println(x[i]);
        }

        double sum = 0;
        for(int i = 0; i<x.length; i++){
            
            if(i == 0 || i == x.length - 1){ // ตัวแรก หรือ ตัวท้าย
                sum += (Math.pow(x[i],7)) + (2*Math.pow(x[i],3)) - 1;
                
            }
            else if(i % 2 == 0){
                sum += 2*((Math.pow(x[i],7)) + (2*Math.pow(x[i],3)) - 1);
                
            }
            else{
                sum += 4*((Math.pow(x[i],7)) + (2*Math.pow(x[i],3)) - 1);
                
            }
        }

        sum *= (h/3);
        
        double y0 = (Math.pow(x[0],8)/8) + (2*Math.pow(x[0],4)/4) - x[0];
        double y1 = (Math.pow(x[x.length-1],8)/8) + (2*Math.pow(x[x.length-1],4)/4) - x[x.length-1];
        
        double i_r = y1 - y0;
        // System.out.println(i_r);

        double error = (i_r - sum) / i_r * 100;

        return error;
    }
}
