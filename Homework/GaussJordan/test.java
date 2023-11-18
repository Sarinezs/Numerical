import java.util.Scanner;

public class test{

    public void echelonform(double[][] a, double[] b){
        int n = a.length;
        double[][] m = new double[n][2*n];
        double[][] identity = new double[n][n];
       
        for(int i = 0; i<n; i++){
            identity[i][i] = 1;
            for(int j = 0; j<n; j++){
                m[i][j] = a[i][j];
                m[i][j+n] = identity[i][j];
            }
        }
        
        // loop คำนวณให้เป็น form ตามแบบ echelonform
        
        for(int k = 0;k < n; k++){
            double pivot = m[k][k];
            b[k] /= pivot;
            for(int i = 0; i<2*n; i++){
                m[k][i] /= pivot;
            }
            for(int i = 0; i<n; i++){
                if(i != k){
                    double factor = m[i][k];
                    b[i] -= factor*b[k];
                    for(int j = 0; j<2*n; j++){
                        m[i][j] -= factor*m[k][j];
                    }
                }
            }
        }
        
         printechelon(m,b);
    }

    // อันนี้แค่ปริ้นเฉยๆ ไม่มีอะไร
    public void printechelon(double[][] a, double[] b){
        int n = a.length;
        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(String.format("%.2f", a[i][j])+" ");
            }
            for(int j = 3; j<n*2; j++){
                System.out.print(String.format("%.2f", a[i][j])+" ");
            }
            System.out.print(" | "+String.format("%.2f", b[i])+" ");    
            System.out.println();
        }
    }
    //อันนี้คือ หลังจากที่จัดรูปเสร็จแล้ว loop นี้จะย้ายข้างหาคำตอบ x1,x2,x3
    public double[] solve(double[][] a, double[] b){
        int n = b.length;
        double[] solution = new double[n];

        for(int i = n-1; i>=0; i--){
            double sum = 0.0;
            for(int j = i+1; j<n; j++){         //รอบแรกจะไม่เข้าfor นี้ เพราะเป็น x3 ที่มันย้ายข้างแล้วได้คำตอบเลย
                sum += a[i][j] * solution[j];   //loop นี้เอาไว้ช่วยหาคำตอบ x2 กับ x1
            }
            solution[i] = (b[i] - sum) /a[i][i];    // ตรงนี้จะเป็นคำตอบที่คำนวณได้ x1,x2,x3นั้นแหละ
        }

        return solution;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        test ge = new test();
        double[][] a = {{-2,3,1},{3,4,-5},{1,-2,1}};
        double[] b = {9,0,-4};


        ge.echelonform(a,b);
        // double[] x = ge.solve(a,b);
        // ge.printechelon(a,b);
        // System.out.println("X1 = "+String.format("%.2f", x[0]));
        // System.out.println("X2 = "+String.format("%.2f", x[1]));
        // System.out.println("X3 = "+String.format("%.2f", x[2]));
    }
}