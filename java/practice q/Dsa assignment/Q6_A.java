public class Q6_A {
    static void nearestLarger(int arr[], int n){
        int next_index , i , j;
        int index = 1;

        
        for ( i = 0; i < n; i++) {
            next_index  = -1;
            for ( j = i+1; j <n-1; j++) {
                if(arr[i]< arr[j]){
                    next_index = j+1;
                    break;
                }
                
            }
            System.out.print(next_index + " ");
            
            
        }
        System.out.println();
        
        for ( i = 0; i < n; i++) {
            next_index  = -1;
            for ( j = i+1; j <n-1; j++) {
                if(arr[i]< arr[j]){
                    next_index = j+1;
                    break;
                }
                
            }
            if(next_index != -1)
            System.out.println("For player at index" + index + "the nearest friend is at index " +  next_index + "having a match value " + arr[j]);
            else
            System.out.println("For player at index" + index + " there is no nearest friend found ");
            index++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[]= {2,5,9,3,1,12,6,8,7};
        int n = arr.length;
        nearestLarger(arr, n);
    }
}
