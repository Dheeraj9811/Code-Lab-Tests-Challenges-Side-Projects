import java.util.Scanner;

public class Factorial {


    static int Facto(int n){

        if(n <= 1){
            return 1;
        }else{
            return(n*Facto(n-1));
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        System.out.println(Facto(x));
        
    }
}
