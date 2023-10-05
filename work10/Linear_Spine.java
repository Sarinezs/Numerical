public class Linear_Spine {
    public static void main(String[] args){
        double x_value = 4.5;
        double[] ex = {2,4,6,8,10};
        double[] fx = {9.5,8,10.5,39.5,72.5};
        double solution = 0;

        double[] m = new double[ex.length];

        for(int i = 1; i<m.length; i++){
            m[i] = (fx[i] - fx[i-1]) / (ex[i] - ex[i-1]);
        }
        

        if(ex[0]<=x_value && x_value<=ex[1]){
            solution = fx[0] + m[1]*(x_value-ex[0]);
        }
        else if(ex[1]<=x_value && x_value<=ex[2]){
            solution = fx[1] + m[2]*(x_value-ex[1]);
        }
        else if(ex[2]<=x_value && x_value<=ex[3]){
            solution = fx[2] + m[3]*(x_value-ex[2]);
        }
        else if(ex[3]<=x_value && x_value<=ex[4]){
            solution = fx[3] + m[4]*(x_value-ex[3]);
        }

        System.out.print(String.format("%.6f", solution)+" ");
    }
}
