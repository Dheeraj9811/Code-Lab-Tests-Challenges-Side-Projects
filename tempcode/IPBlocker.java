import java.util.*;

public class IPBlocker {
    // 
    void mergesort(int[] arr, int l, int r){
        if(l<r){
            int mid = l +(r-l)/2;
            mergesort(arr, l, mid);
            mergesort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    void merge(int[] arr, int l, int mid , int r ){
        int ans[] = new int[r+1];
        int ptr = l, i = l, j = mid+1  ;
        
        while(i<=mid && j<=r ){
            if(arr[i]< arr[j]){
                ans[ptr] = arr[i];
                i++;
            }
            else{
                ans[ptr] = arr[j];
                j++;
            }

            ptr++;
        }
        
        // copying left over
        while(i<=mid){
            ans[ptr] = arr[i];
            i++; ptr++;
        }

        while(j<=r){
            ans[ptr] = arr[j];
            j++; ptr++;
        }

        // copying into main arr
        for(int k = l; k<=r; k++){
            arr[k] = ans[k];
        }

    }

    void quicksort(int[] arr, int l, int r){
        if(l<r){
            int pivot = partition(arr, l, r);
            quicksort(arr, l, pivot-1);
            quicksort(arr, pivot+1, r);
        }
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int partition(int arr[], int l , int r){
        int piv = arr[l];

        int i = l;
        int j = r;
        while(i<j){

            // finding element greater than pivot
            while(i<=r && arr[i]<=piv){
                i++;
            }
            // finding element smaller than pivot
            while(j>l && arr[j]>piv){
                j--;
            }
            // swap the elemets
            if(i<j){
                swap(arr, i, j);
            }
        }

        // now postion the piviot lement to its right postion
        swap(arr, l, j);
        // returning pivot index so that we can divide the array into two parts and sort them
        return j;

    }
   

    public static void main(String[] args) {    
        // calling the function
        IPBlocker ipBlocker = new IPBlocker();
        int[] arr = {12,1,2,3,1000000,4,5,6,-2100000,7,8,9,10,11,13,14,15,16,17,18,19,20};
        ipBlocker.mergesort(arr, 0, arr.length-1);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        // call quick sort
        System.out.println();
        ipBlocker.quicksort(arr, 0, arr.length-1);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}