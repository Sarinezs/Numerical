// package work3;

public class newraph {
    public static void main(String[] args){
        double x0 = 2;
        double xold;
        double x1;
        do {
            xold = x0;
            x1 = x0 + Math.sqrt(7) - x0; 
            x0 = x1;
        } while (Math.abs((x1 - xold)/x1)*100 >= 0.000001);
        System.out.println(x1);
    }
}
