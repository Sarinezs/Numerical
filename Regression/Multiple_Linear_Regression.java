public class Multiple_Linear_Regression {
    public static void main(String[] args){
        // int[] x1 = {1,0,2,3,4,2,1};
        // int[] x2 = {0,1,4,2,1,3,6};
        // int[] x3 = {1,3,1,2,5,3,4};
        double[][] x = {{1,0,2,3,4,2,1}, // x1
                    {0,1,4,2,1,3,6},  // x2
                    {1,3,1,2,5,3,4}}; // x3
        double[] y = {4,-5,-6,0,-1,-7,-20};
        int[] xvalue = {1,2,3};
        int m = 4;
        
        double[] solution = Regression(x, y, m);

        double sum = solution[0];
        for(int i = 1; i<solution.length; i++){
            sum += solution[i]*xvalue[i-1];
        }
        System.out.println("Assume : \nx1 = "+xvalue[0]+" \nx2 = "+xvalue[1]+" \nx3 = "+xvalue[2]);
        System.out.println("g("+xvalue[0]+","+xvalue[1]+","+xvalue[2]+") = "+String.format("%.0f", sum));
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

    public static double[] Regression(double[][] x, double[] y, int m){
        double[][] a = new double[m][m];
        double[] b = new double[m];
        double[] solution = new double[m];

        for(int i = 0; i<a.length; i++){ // loop หาค่าใส่เมทริกซ์ A
            for(int j = 0; j<a[i].length; j++){
                double sum_x = 0;
                if(i == 0 && j == 0){
                    a[i][j] = x[i].length; // เก็บจำนวนข้อมูล x ว่ามีกี่ตัว
                    continue;
                }
                for(int k = 0; k<x[1].length; k++){
                    if(i == 0 ){
                        sum_x += Math.pow(x[j-1][k],1);
                    }
                    else if(j == 0){
                        sum_x += Math.pow(x[i-1][k],1);
                    }
                    else{
                        sum_x += x[i-1][k]*x[j-1][k];
                    }
                }
                a[i][j] = sum_x;
            }
        }

        for(int i = 0; i<b.length; i++){ // loop หาค่าใส่เมทริกซ์ B
            double sum_y = 0;
            if(i != 0){ // Sigma yi * xi
                for(int j = 0; j<x[1].length; j++){
                    sum_y += x[i-1][j]*y[j];
                }
            }
            else{ // Sigma of y only
               for(int j = 0; j<x[1].length; j++){
                    sum_y += y[j];
                } 
            }
            b[i] = sum_y;
        }

        solution = echelonform(a, b);
        return solution;
    }
}
