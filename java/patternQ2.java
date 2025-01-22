import java.util.Scanner;

public class patternQ2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter number");
        int n = input.nextInt();
        for (int i = 0 ; i < n ;i++) {
            for (int j = 0 ; j <= i ; j ++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
}
