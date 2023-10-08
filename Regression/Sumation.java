// package Regression;

public class Sumation {
    public static void main(String[] args){
        int[] x = {10,15,20,30,40,50,60,70,80};
        int[] y = {5,9,15,18,22,30,35,38,43};
        double[][] a = {{7,13,17,19},
                        {13,35,31,38},
                        {17,31,67,49},
                        {19,38,49,65}};
        double[] b = {-35,-46,-171,-123};

        double[][] test = new double[3][3];
        double[] testb = new double[3];
        
        

        for(int i = 0 ; i<test.length; i++){// loop หาค่าใส่ในเมทริกซ์ A
            for(int j = 0; j<test[i].length; j++){
                double sum_x = 0;
                if(i == 0 && j == 0){
                    test[i][j] = x.length;
                    continue;
                }
                for(int k = 0; k<x.length; k++){ 
                    if(i != 0){ // คำนวณค่าตั้งแต่แถว 2 ลงมา
                        sum_x += Math.pow(x[k], j+i);
                    }
                    else{ // คำนวณค่าเฉพาะที่แถวแรก
                        sum_x += Math.pow(x[k],j);
                    }
                }
                test[i][j] = sum_x;
            }
        }

        for(int i = 0; i<testb.length; i++){ // loop หาค่าใส่เมทริกซ์ B
            double sum_y = 0;
            for(int j = 0; j<x.length; j++){
                sum_y += y[j]*Math.pow(x[j],i);
                
            }
            testb[i] = sum_y;
        }

        // for(int i = 0; i<test.length; i++){
        //     for(int j = 0; j<test[i].length; j++){
        //         System.out.print(test[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        // for(int i = 0; i<testb.length; i++){
        //     System.out.println(testb[i]);
        // }

        echelonform(test, testb);
        double[] solution = solve(test, testb);

        for(int i = 0; i<test.length; i++){
            for(int j = 0; j<test[i].length; j++){
                System.out.print(String.format("%.2f", test[i][j])+" ");
            }
            System.out.println("| "+String.format("%.2f", testb[i]));

        }

        for(int i = 0; i<solution.length; i++){
            System.out.println(solution[i]);
        }
    }

    public static void echelonform(double[][] a, double[] b){
        int n = b.length;

        for(int k = 0;k < n; k++){
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
