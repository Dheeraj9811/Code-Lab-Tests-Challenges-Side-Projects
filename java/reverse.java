import java.util.Scanner;

public class reverse {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in) ;
        int n = input.nextInt();
        int reverse = 0 , temp = n , last_digit ;

        while (temp > 0 ) {
            last_digit = temp %10 ;
            reverse = reverse * 10 + last_digit ;
            temp = temp/ 10 ;

        }
        System.out.println("reverse of a numberr "+ n + " is = " + reverse) ;
    }   
    
}
