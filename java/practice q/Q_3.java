import java.util.Scanner;

public class Q_3 {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        

        
        int a , b ;
        a = in.nextInt();
        b = in.nextInt();
        
        System.out.println(Fn(a, b));
        in.close();
    }
     static String Fn (int x , int y) {
        String result;

        if (x >= 0 && y >= 0){

            result = Integer.toString(x*y);    
        }else{
            result = "java.lang.Exception: Breadth and height must be positive";
        }
        return result;

    }

   
    }
    

