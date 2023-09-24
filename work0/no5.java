package work0;
import java.util.Scanner;
// bisection method
public class no5{
    public static void main(String[] args){
        double xl,xr,xm,yl,yr,ym,a,n;
        Scanner sc = new Scanner(System.in);
        xl = 0;
        xr = 1000000;
        System.out.print("Enter x and n : ");
        a = sc.nextDouble();
        n = sc.nextDouble();

        do {
            yl = Math.pow(xl,n) - a;
            yr = Math.pow(xr,n) - a;
            xm = (xl + xr) / 2; 
            ym = Math.pow(xm,n) - a;

            if(ym*yr < 0){
                xl = xm;
            }
            
            else if(ym*yr > 0){
                xr = xm;
            }

        } while (Math.abs(ym) >= 0.0001);
        
        System.out.println(String.format("%.4f", xm));

    }
}