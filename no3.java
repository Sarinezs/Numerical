public class no3{
    public static void main(String[] args){
        double xl,xr,xm,yl,yr,ym;
        xl = 0.02;
        xr = 0.03;
        
        do {
            yl = 43*xl - 1;
            yr = 43*xr - 1;
            xm = (xl + xr) / 2;
            ym = 43*xm - 1;

            if(ym * yr < 0){
                xl = xm;
            }
            
            if(ym * yr > 0){
                xr = xm;
            }
        } while (Math.abs(ym) >= 0.000001);
        
        System.out.println(String.format("%.6f", xm));
    }
}