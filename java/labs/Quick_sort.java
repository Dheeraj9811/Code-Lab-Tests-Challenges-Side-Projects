import java.util.Scanner;

public class Quick_sort { 
    public static void merge(int arr[], int start, int mid, int end)
    {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int L[] = new int[n1];  // left array 
        int R[] = new int[n2]; // right array 

        for (int i = 0; i < n1; ++i)
            L[i] = arr[start + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;

        int k = start;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void sort(int arr[], int start, int end)
    {
        if (start < end) {
            int m =start+ (end-start)/2;

            sort(arr, start, m);
            sort(arr, m + 1, end);

            merge(arr, start, m, end);
        }
    }
    
    // static int merge(int B[], int j, int K){
    //     int i = 0;
    //     int count = 0;
    //     int Z = 1;
    //     if(B[i] > 7 ){
    //         return count;

    //     }else{
    //         int temp = B[i];
    //         if(temp + B[Z] <= 7){
    //             B[i] = temp + B[Z];
    //             Z++;
    //             count++;
    //         }
    //         return merge(B, Z , K);

    //     }
    // }

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n ,K;
        n = in.nextInt();
        int[] A = new int[n];
        K = in.nextInt();
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        
        sort(A, 0, n-1);
        int i = 0;
        int count = 0;
        int Z = 1;
        while(A[i] < K){
            int temp = A[i];
             if(temp + A[Z] <= 7){
                 A[i] = temp + A[Z];
                 Z++;
                 count++;
             }
        }

        // int answer = merge(A, 0 , K);
        if (count == 0)
            System.out.println(-1);

        else{
            System.out.println(count);
        }

        
            
        
        
    }
    
}