import java.util.Scanner;
// q is find sum of 1 -1/2 +1/3 - 1/4 .......+1/n 
public class q1 {
    public static void main(String[] args) {
        System.out.println("enter no.of time to calculate");
        Scanner input = new Scanner(System.in) ;
        int number = input.nextInt();
        float result = 0 ;
        for(int i = 1; i<= number ; i++ ) {
            if (i % 2 == 0) {
                result = result- (float) 1/i ;
            }
            else
            {result = result + (float) 1/i; 
            } 
        }

        System.out.print(result);
    }
    
}
