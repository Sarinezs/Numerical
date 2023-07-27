// bisection method
public class no4{
    public static void main(String[] args){
        double xl,xr,xm,yl,yr,ym;
        xl = 0;
        xr = 10;
        do {
            yl = Math.pow(xl,2) - 7;
            yr = Math.pow(xr,2) - 7;
            xm = (xl + xr) / 2;
            ym = Math.pow(xm,2) - 7;
            
            if(ym * yr < 0){
                xl = xm;
            }
            else if(ym * yr > 0){
                xr = xm;
            }
        } while (Math.abs(ym) >= 0.000001);
        
        System.out.println(String.format("%.6f", xm));

    }
}