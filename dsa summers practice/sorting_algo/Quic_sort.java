public class Quic_sort {
    
    static void quicsort(int arr[], int s , int e ){
        // base case 
        if(s< e){
            
            int pivot = partition(arr, s , e);
    
            quicsort(arr, s, pivot-1); // left sort 
            quicsort(arr, pivot+1, e);// right sort
        }


    }

    static int partition(int arr[], int s , int e){
        int pivot = arr[s];
        int j = e;
        int i = s;
        while(i < j ){
            while(arr[i] <= pivot && i<e){
                i++;
            }
            while(arr[j] > pivot && j>s){
                j--;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }  


        }

        int temp = arr[s];
        arr[s] = arr[j];
        arr[j] = temp;
        return j;

        
    }

    public static void main(String[] args) {
        int arr[] = { 10, 7, 8, 9, 1, 5 }; 

        quicsort(arr, 0, arr.length-1);

        System.out.println("sorted array ");
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
