import java.util.Scanner;

public class gaussian{

    public void echelonform(double[][] a, double[] b){
        int n = b.length;

        for(int k = 0;k < n; k++){
            int max = k;
            for(int i = k + 1; i<n; i++){
                if(Math.abs(a[i][k]) > Math.abs(a[k][k])){ // for นี้เอาไว้checkแถวที่ต้องสลับแถวถ้าตัวล่าง มากกว่า ตัวบน
                    max = i;                               // ครั้งแรกจะเริ่มที่คอลัมภ์แรก
                }
            }

            double[] temp = a[k]; //{
            a[k] = a[max];        //       <--- สลับแถว A 
            a[max] = temp;        //        
                                        // aคือก้อนใหญ่ b คือก้อนคำตอบ
            double t = b[k];      //
            b[k] = b[max];        //       <--- สลับแถว B
            b[max] = t;           //        
                                  //}
            // loop คำนวณให้เป็น form ตามแบบ echelonform
            for(int i = k+1; i<n; i++){
                double factor = a[i][k] / a[k][k]; //เอาตัวล่างส่วนตัวบน ลองเขียนดู
                b[i] = b[i] - factor *b[k];
                for(int j = k; j<n; j++){
                    a[i][j] = a[i][j] - factor * a[k][j];
                }
            }

            
        }
    }

    // อันนี้แค่ปริ้นเฉยๆ ไม่มีอะไร
    public void printechelon(double[][] a, double[] b){
        int n = b.length;
        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(String.format("%.2f", a[i][j])+" ");
            }
            System.out.print("| "+String.format("%.2f",b[i])+"\n");
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
        gaussian ge = new gaussian();
        double[][] a = {{-2,3,1},{3,4,-5},{1,-2,1}};
        double[] b = {9,0,-4};


        ge.echelonform(a,b);
        double[] x = ge.solve(a,b);
        ge.printechelon(a,b);
        System.out.println("X1 = "+String.format("%.2f", x[0]));
        System.out.println("X2 = "+String.format("%.2f", x[1]));
        System.out.println("X3 = "+String.format("%.2f", x[2]));
    }
}