public class Cubic_Spine {
    public static void main(String[] args){
        double[][] a = {{64,16,4,1,0,0,0,0,0,0,0,0,0,0,0,0}             //  1
                        ,{0,0,0,0,64,16,4,1,0,0,0,0,0,0,0,0}            //  2  
                        ,{0,0,0,0,216,36,6,1,0,0,0,0,0,0,0,0}           //  3
                        ,{0,0,0,0,0,0,0,0,216,36,6,1,0,0,0,0}           //  4
                        ,{0,0,0,0,0,0,0,0,512,64,8,1,0,0,0,0}           //  5
                        ,{0,0,0,0,0,0,0,0,0,0,0,0,512,64,8,1}           //  6
                        ,{8,4,2,1,0,0,0,0,0,0,0,0,0,0,0,0}              //  7
                        ,{0,0,0,0,0,0,0,0,0,0,0,0,1000,100,10,1}        //  8
                        ,{48,8,1,0,-48,-8,-1,0,0,0,0,0,0,0,0,0}         //  9
                        ,{0,0,0,0,108,12,1,0,-108,-12,-1,0,0,0,0,0}     //  10
                        ,{0,0,0,0,0,0,0,0,192,16,1,0,-192,-16,-1,0}     //  11
                        ,{24,2,0,0,-24,-2,0,0,0,0,0,0,0,0,0,0}          //  12
                        ,{0,0,0,0,36,2,0,0,-36,-2,0,0,0,0,0,0}          //  13
                        ,{0,0,0,0,0,0,0,0,48,2,0,0,-48,-2,0,0}          //  14
                        ,{12,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0}             //  15
                        ,{0,0,0,0,0,0,0,0,0,0,0,0,60,2,0,0}};           //  16
        double[] b = {8,8,10.5,10.5,39.5,39.5,9.5,72.5,0,0,0,0,0,0,0,0};

        echelonform(a,b);
        double[] x = solve(a,b);

        // for(int j = 0; j<4; j++){
        //     if(j == 0){
        //         for(int i = 0; i<4; i++){
        //             System.out.print(String.format("%.2f", x[i])+" ");
        //         }
        //     }
        //     else if(j == 1){
        //         for(int i = 4; i<8; i++){
        //             System.out.print(String.format("%.2f", x[i])+" ");
        //         }
        //     }
        //     else if(j == 2){
        //         for(int i = 8; i<12; i++){
        //             System.out.print(String.format("%.2f", x[i])+" ");
        //         }
        //     }
        //     else if(j == 3){
        //         for(int i = 12; i<16; i++){
        //             System.out.print(String.format("%.2f", x[i])+" ");
        //         }
        //     }
            
            
        //     System.out.println("");
        // }

        double x_value = 4.5;
        double[] ex = {2,4,6,8,10};
        double[] fx = {9.5,8,10.5,39.5,72.5};
        double solution = 0;

        if(ex[0]<=x_value && x_value<=ex[1]){
            solution = (x[0]*(Math.pow(x_value, 3)) + x[1]*(Math.pow(x_value, 2)) + x[2]*x_value + x[3]); 
        }
        else if(ex[1]<=x_value && x_value<=ex[2]){
            solution = (x[4]*(Math.pow(x_value, 3)) + x[5]*(Math.pow(x_value, 2)) + x[6]*x_value + x[7]); 
        }
        else if(ex[2]<=x_value && x_value<=ex[3]){
            solution = (x[8]*(Math.pow(x_value, 3)) + x[9]*(Math.pow(x_value, 2)) + x[10]*x_value + x[11]); 
        }
        else if(ex[3]<=x_value && x_value<=ex[4]){
            solution = (x[12]*(Math.pow(x_value, 3)) + x[13]*(Math.pow(x_value, 2)) + x[14]*x_value + x[15]);
        }

        System.out.print(String.format("%.6f", solution)+" ");
    }

    public static void echelonform(double[][] a, double[] b){
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
        
            // loop คำนวณให้เป็น form ตามแบบ echelonform
            for(int i = k+1; i<n; i++){
                double factor = a[i][k] / a[k][k]; //เอาตัวล่างส่วนตัวบน
                b[i] = b[i] - factor *b[k];
                for(int j = k; j<n; j++){
                    a[i][j] = a[i][j] - factor * a[k][j];
                }
            }
        }
    }

    public static void printechelon(double[][] a, double[] b){
        int n = b.length;
        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(String.format("%.2f", a[i][j])+" ");
            }
            System.out.print("| "+String.format("%.2f",b[i])+"\n");
        }
    }

    public static double[] solve(double[][] a, double[] b){
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
}
