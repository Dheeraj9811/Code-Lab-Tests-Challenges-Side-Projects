import java.util.Scanner;

public class Lab_4 { 
    static void q_s(int [] arr , int l ,int h){
        
        int i = l+1 , j = h, temp ;
        int pivot = arr[l];
        while(i<=j){
            while(arr[i]< pivot && i <=j){
                i++;
            }
            while(arr[j]>pivot){
               j--;
           } 
           if(i<j){
               temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               i++; j--;
           } 
        }temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        if (l<j-1)
            q_s(arr, l, j-1);
        if(j+1< h)
            q_s(arr, j+1, h);
    }
    

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n ;
        n = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        
        q_s(A, 0, n-1);
        for (int i : A) {
            System.out.print(i  + " ");
            
        }
        
    }
    
}