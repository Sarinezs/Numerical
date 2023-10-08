public class Multiple_Linear_Regression {
    public static void main(String[] args){
        // int[] x1 = {1,0,2,3,4,2,1};
        // int[] x2 = {0,1,4,2,1,3,6};
        // int[] x3 = {1,3,1,2,5,3,4};
        double[][] x = {{1,0,2,3,4,2,1}, // x1
                    {0,1,4,2,1,3,6},  // x2
                    {1,3,1,2,5,3,4}}; // x3
        int[] y = {4,-5,-6,0,-1,-7,-20};
        int m = 4;
        double[][] a = new double[m][m];
        double[] b = new double[m];

        for(int i = 0; i<a.length; i++){
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

        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a[i].length; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();

        }
    }
}
