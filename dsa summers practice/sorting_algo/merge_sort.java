class merge_sort 
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]

    /*Step 1 − if it is only one element in the list it is already sorted, return.
Step 2 − divide the list recursively into two halves until it can no more be divided.
Step 3 − merge the smaller lists into new list in sorted order. */
    void merge(int arr[], int l, int m, int r)
    {
        int i = l , j = m+1;
        int k = l ; // used to fill new array 
        int[] b = new int[r+1]; // mistake i made b = r it should be r+1
        while(i<= m && j<=r){
            if(arr[i]<arr[j]){
                b[k]= arr[i];
                i++;
            }
            else{
                b[k] = arr[j];
                j++;
            }
            k++;
        }
        while(j<=r){
            b[k] = arr[j];
            j++; k++;
        }
        while(i<=m){
            b[k]= arr[i];
            i++; k++;
        }

        for(k = l ; k<=r;k++){
            arr[k] = b[k];
        }
        
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =(l+ r)/2;
  
            // Sort first and second halves
            // System.out.println("hi");
            sort(arr, l, m);
            sort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
  
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
  
    // Driver code
    public static void main(String args[])
    {
        int arr[] = {10, -10 , -11 , -1 ,2};
  
        System.out.println("Given Array");
        printArray(arr);
  
        merge_sort ob = new merge_sort();
        ob.sort(arr, 0, arr.length-1);

        for (int i : arr) {
            System.out.println(i);
        }
  
        System.out.println("\nSorted array");
        printArray(arr);


    }
}