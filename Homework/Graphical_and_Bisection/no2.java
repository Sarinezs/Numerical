// package work0;
// bisection method
public class no2{
    public static void main(String[] args){
        double xl = 0;
        double xr = 100;
        double xm;
        double yl;
        double yr;
        double ym;
        
        do{
            xm = (xl + xr) / 2;
            yl = (Math.pow(xl, 4) - 13);
            yr = (Math.pow(xr, 4) - 13);
            ym = (Math.pow(xm, 4) - 13);
            if(ym * yr < 0){
                xl = xm;
            }
            else if(ym * yr > 0){
                xr = xm;
            }
        }
        while(Math.abs(ym) >= 0.000001);

        System.out.println(String.format("%.6f", xm));
    }
}