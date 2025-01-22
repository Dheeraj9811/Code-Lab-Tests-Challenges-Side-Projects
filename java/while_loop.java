import java.util.Scanner;

public class while_loop {//sum of digit 
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int n = input.nextInt();
            int result = 0 ;
            int temp = n;
            while (temp >0) {
                 result = temp % 10 + result ;
                 temp = temp / 10 ;

            }
            System.out.println("sum of digit is = " + result );
        }

    }
    
}
