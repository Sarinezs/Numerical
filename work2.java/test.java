public class test {
    public static void main(String[] args){
        double x0 = 0;
        double xold; 
        double x1;
        do {
            xold = x0;
            x1 = (x0+7) / (x0+1);
            x0 = x1;
        } while (Math.abs((x1-xold)/x1*100) >= 0.000001);
        System.out.println(x1);
    }
    
}
