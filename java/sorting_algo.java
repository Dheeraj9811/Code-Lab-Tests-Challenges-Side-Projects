import java.util.Arrays;

public class sorting_algo {
    public static void main(String[] args){
        // bubble sort 
        int a[] = {2,1,8,-3,6,4,12};
        int n = a.length , temp ;
        for( int i = 0 ; i < n-1 ; i++){
            for (int j = 0 ; j < (n-1) - i ; j++){
                if ( a[j] > a[j+1]  ) {
                    temp = a[j] ;
                    a[j] = a[j+1] ;
                    a[j+1] = temp;
                }
                
            }
        }
        System.out.println(Arrays.toString(a));

        System.out.println("here it is slection sort ");

        int pos ,smallest ;

        for (int i = 0 ; i < n ; i++ ){
            smallest = a[i] ;
            
            for ( int j = i+1 ; j< n ; j++) {

                if (a[j] < smallest) {
                    smallest = a[j];
                    pos = (int) j ;
                } 
            }
            temp = a[i];
            a[i] = smallest;
            a[pos] = temp;
        } 
        System.out.println(Arrays.toString(a));

    }
    
}
