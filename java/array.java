import java.net.SocketPermission;
import java.util.Arrays;
import java.util.Scanner;
public class array { // how to initalization of array   
    public static void main(String[] args) {
        int[] array = new int[5]; // or int array [] = new int [5] , give us same result
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
      //  System.out.println(array); 
      // here it will give reffernce variable location "[I@2401f4c3"
        // so we need different method to print array  so we will use class 'Arrays' 
        System.out.println(Arrays.toString(array));


        // short cut method to initalization of array 
        int [] array_1 = {1,2,3,3,5} ;                      
        System.out.println(Arrays.toString(array_1));
        System.out.println(array_1.length);
        for( int i = 0; i < array_1.length; i++) {
          System.out.println(array_1[i]);
        }
        Scanner input = new Scanner(System.in);
        System.out.print("now enter your own value ") ;
        for( int i = 0 ; i<  5; i++ ) {
          array[i] = input.nextInt(); 
          
        }


    }
    
}
