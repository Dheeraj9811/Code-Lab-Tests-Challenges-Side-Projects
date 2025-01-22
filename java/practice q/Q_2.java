import java.util.Scanner;

class My_fn {
    public String Fn(int a , int b) {
        String result;

        if (a >= 0 && b >= 0){

            result = Integer.toString(a*b);    
        }else{
            result = "java.lang.Exception: Breadth and height must be positive";
        }
        return result;

    }
}





public class Q_2 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int a , b ;
        a = in.nextInt();
        b = in.nextInt();
        My_fn yes_1 = new My_fn();
        System.out.println( yes_1.Fn(a, b));

    }

}
