public class Simpson_Rule {
    public static void main(String[] args){
        double h = (2.0 - (-1.0)) / 2;
        double[] a = new double[2+1];
        // System.out.println(h);
        a[0] = -1;
        for(int i = 1; i<a.length; i++){
            a[i] = a[i-1] + h;
            // System.out.println(a[i]);
        }

        double sum = 0;
        double y = 0;
        for(int i = 0; i<a.length; i++){
            if(i == 0 || i == a.length - 1){
                y = (Math.pow(a[i],7)) + (2*Math.pow(a[i],3)) - 1;
                // System.out.println(y);
            }
            else if(i % 2 == 0){
                y = 2*(Math.pow(a[i],7)) + (2*Math.pow(a[i],3)) - 1;
                // System.out.println(y);
            }
            else if(i % 2 == 1){
                y = 4*(Math.pow(a[i],7)) + (2*Math.pow(a[i],3)) - 1;
                // System.out.println(y);
            }
            sum += y;
        }

        double y0 = (Math.pow(a[0],8)/8) + (2*Math.pow(a[0],4)/4) - a[0];
        double y1 = (Math.pow(a[a.length-1],8)/8) + (2*Math.pow(a[a.length-1],4)/4) - a[a.length-1];

        double i = (h/3)*(sum);
        double i_r = y1 - y0;
        
        double ans = ((i_r - i) / i_r) * 100;
        System.out.println(ans);
    }
}
