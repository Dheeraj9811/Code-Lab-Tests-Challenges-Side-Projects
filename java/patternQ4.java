import java.util.Scanner;

public class patternQ4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("enter number");
        int n = input.nextInt();

        for (int i = 0 ; i < n ;i++) {
            for (int j = 0 ; j< n ; j ++) {
                if (j +i >= n-1 ) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
                
            }
            System.out.println();
        }
    }
    
}
