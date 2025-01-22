import java.util.Scanner;

import javax.xml.transform.Result;

public class Q1_midem {
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
    public static void main(String[] args) {
        int zombi_count, special_move;
        Scanner input = new Scanner(System.in);
        zombi_count = input.nextInt();
        special_move = input.nextInt();
        int[] arr = new int[zombi_count]; 
        long sum = 0 ;
        
        for (int i = 0; i < zombi_count; i++) {
            arr[i] = input.nextInt();
            sum += arr[i]; 
        }
        if(special_move > zombi_count){
            System.out.println("0");
            return;
        }
        if(special_move == 0 ){
            System.out.println(sum);
            return;
        }
        sort(arr, 0, zombi_count-1);
        System.out.println();

        long result = 0 ;
        for (int i = 0; i < zombi_count-special_move; i++) {
            
            result += arr[i];
            
        }
        System.out.println(result);
        
    }
}
