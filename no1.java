// Graphical method
public class no1 {
    public static void main(String[] args){
        double x = 0;
        double y1 = (43*x)-180;
   
        for(x = 1; x<11; x++){
            double y2 = 43*x-180;
            if(y1*y2 >0){
                y1 = y2;
            }
            else if(y1*y2 <= 0){
                break;
            }
        }
        double a = x-1;
        double b = x;
        double y3 = 43*a-180;
        
        while(y3!=0 && a<=b){
            a = a + 0.000001;
            y3 = 43*a-180;
            if(y3>= 0.0){
                break;
            }
        }
        System.out.print("result is "+a);
    }
}
