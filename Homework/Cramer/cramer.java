// import java.util.Scanner;
class det{
    private int[][] a = new int[3][3];
    private int[] b = new int[3];

    public void seta(int[][] a){
        this.a = a;
    }

    public void setb(int[] b){
        this.b = b;
    }


    public int caldet_A(){
        int det = (a[0][0]*((a[1][1]*a[2][2])-(a[2][1]*a[1][2]))) 
                - (a[0][1]*((a[1][0]*a[2][2])-(a[2][0]*a[1][2]))) 
                + (a[0][2]*((a[1][0]*a[2][1])-(a[2][0]*a[1][1])));
        return det;
    }

    public double cramer(double[][] a, double[] b){
        double A = 0;
        
        return A;
    }

    public int caldet_a(int c){
        int det;
        
        switch(c){
            case 1:
                det = (b[0]*((a[1][1]*a[2][2])-(a[2][1]*a[1][2]))) - (a[0][1]*((b[1]*a[2][2])-(b[2]*a[1][2]))) 
                    + (a[0][2]*((b[1]*a[2][1])-(b[2]*a[1][1])));
                break;
            case 2:
                det = (a[0][0]*((b[1]*a[2][2])-(b[2]*a[1][2]))) - (b[0]*((a[1][0]*a[2][2])-(a[2][0]*a[1][2]))) 
                     +(a[0][2]*((a[1][0]*b[2])-(a[2][0]*b[1])));
                break;
            case 3:
                det = (a[0][0]*((a[1][1]*b[2])-(a[2][1]*b[1]))) - (a[0][1]*((a[1][0]*b[2])-(a[2][0]*b[1]))) 
                    + (b[0]*((a[1][0]*a[2][1])-(a[2][0]*a[1][1])));
                break;
            default:
                return 1;
        }

        return det;
    }

}

public class cramer {
    public static void main(String[] args){
        det m1 = new det();
        int[][] a = {{-2,3,1},{3,4,-5},{1,-2,1}};
        int[] b = {9,0,-4};

        m1.seta(a);
        m1.setb(b);

        System.out.println("x1 = "+m1.caldet_a(1)/m1.caldet_A());
        System.out.println("x2 = "+m1.caldet_a(2)/m1.caldet_A());
        System.out.println("x3 = "+m1.caldet_a(3)/m1.caldet_A());
        
    }


}
