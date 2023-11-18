public class jacobi{
    public static void main(String[] args){
        double[][] a = {{5,2,0,0},{2,5,2,0},{0,2,5,2},{0,0,2,5}};
        double[] xnew = {0, 0, 0, 0};
        double[] xold ={0,0,0,0};
        double[] b= {12,17,14,7};
        int k = 0;

        do{
            k++;

            for(int i = 0; i<xold.length; i++){
                xold[i] = xnew[i];
            }

            for(int i = 0; i<a.length; i++){
                double sum = 0;
                for(int j = 0; j<a[i].length; j++){
                    if(i == j){
                        continue;
                    }
                    else{
                        sum += a[i][j]*xold[j];
                    }
                }

            xnew[i] = (b[i] - sum)/a[i][i];

        }

    }while(Math.abs((xnew[0] - xold[0])/xnew[0])*100 >= 0.001 && Math.abs((xnew[1] - xold[1])/xnew[1])*100 >= 0.001 
            && Math.abs((xnew[2] - xold[2])/xnew[2])*100 >= 0.001 && Math.abs((xnew[3] - xold[3])/xnew[3])*100 >= 0.001);
        
        System.out.println("X1 : "+String.format("%.3f", xnew[0])+" "+"\nX2 : "+String.format("%.3f", xnew[1])+" "
                            +"\nX3 : "+String.format("%.3f", xnew[2])+" "+"\nX4 : "+String.format("%.3f", xnew[3]));
        System.out.print("Count : "+k);

    }
}