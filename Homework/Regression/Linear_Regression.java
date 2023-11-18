public class Linear_Regression {
    public static void main(String[] args){
        int[] x = {10,15,20,30,40,50,60,70,80};
        int[] y = {5,9,15,18,22,30,35,38,43};
        int m = 2;
        int xvalue = 65;
        double sum;

        double[] solution = Regression(x, y, m);

        sum = solution[0]; // เก็บค่า a0 จะได้ง่ายใน loop
        for(int i = 1; i<m; i++){ // i = 1 เพราะ เก็บa0ไปแล้ว
            sum += solution[i]*Math.pow(xvalue,i);
        }

        System.out.println(String.format("%.4f", sum));

    }

    public static double[] echelonform(double[][] a, double[] b){
        int n = b.length;
        double[] solution = new double[n];

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

        for(int i = n-1; i>=0; i--){
            double sum = 0.0;
            for(int j = i+1; j<n; j++){         //รอบแรกจะไม่เข้าfor นี้ เพราะเป็น x3 ที่มันย้ายข้างแล้วได้คำตอบเลย
                sum += a[i][j] * solution[j];   //loop นี้เอาไว้ช่วยหาคำตอบ x2 กับ x1
            }
            solution[i] = (b[i] - sum) /a[i][i];    // ตรงนี้จะเป็นคำตอบที่คำนวณได้ x1,x2,x3นั้นแหละ
        }

        return solution;
    }

    public static double[] Regression(int[] x, int[] y, int m){
        double[][] a = new double[m][m];
        double[] b = new double[m];
        double[] solution = new double[m];
        

        for(int i = 0 ; i<a.length; i++){// loop หาค่าใส่ในเมทริกซ์ A
            for(int j = 0; j<a[i].length; j++){
                double sum_x = 0;
                if(i == 0 && j == 0){
                    a[i][j] = x.length;
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
                a[i][j] = sum_x;
            }
        }

        for(int i = 0; i<b.length; i++){ // loop หาค่าใส่เมทริกซ์ B
            double sum_y = 0;
            for(int j = 0; j<x.length; j++){
                sum_y += y[j]*Math.pow(x[j],i);
                
            }
            b[i] = sum_y;
        }

        solution = echelonform(a, b);
        return solution;
    }

}
