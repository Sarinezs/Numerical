// package work2.java;
// false position method
public class no1 {
    public static void main(String[] args){
        double xl,xr,x1,yl,yr,y1;
        xl = 1.5;
        xr = 2.0;
        do {
            yl = Math.pow(xl,4) - 13;
            yr = Math.pow(xr,4) - 13;
            x1 = (xl*yr - xr*yl) / (yr-yl);
            y1 = Math.pow(x1,4) - 13;
            
            if(y1 * yr < 0){
                xl = x1;
            }
            else if(y1 * yr > 0){
                xr = x1;
            }
        } while (Math.abs(y1) >= 0.000001);
        
        System.out.println(String.format("%.6f", x1));
    }
}
