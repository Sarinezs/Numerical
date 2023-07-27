import java.util.Scanner;
public class test{
    public static void main(String[] args){
        double a,b,xl,xr,xm,yl,yr,ym;
        Scanner sc = new Scanner(System.in);
        a = sc.nextDouble();
        b = sc.nextDouble();
        xl = 0;
        xr = 1000000;
        do{
            xm = (xl+xr) / 2;
            yl = Math.pow(xl,b) - a;
            yr = Math.pow(xr,b) - a;
            ym = Math.pow(xm,b) - a;            

            if(ym * yr > 0){
                xr = xm;
            }
            else if(ym*yr<=0){
                xl = xm;
            }
        }while(Math.abs(ym) >= 0.0001);

        System.out.println(xm);
    }
}