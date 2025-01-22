import java.util.Arrays;
import java.util.Scanner;

public class array2D { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter no of rows and columm");
        int row = input.nextInt() , columm = input.nextInt() , a[][] = new int[row][columm] ;

        for ( int i = 0 ; i < row ; i++){
            for (int j= 0 ; j < columm ; j++){
                a[i][j] = input.nextInt();
            }
        }

        System.out.println(Arrays.toString(a));
        
    }
    
}
