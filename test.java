public class test {
    public static void main(String[] args){
        System.out.println(recursive(2));
    }

    public static int  recursive(int a){
        if(a == 1){
            return 1;
        }
        else{
            return 1 + recursive(a-1);
        }
    }
}
