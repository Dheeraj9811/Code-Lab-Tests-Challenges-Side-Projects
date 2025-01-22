class merge_sort{

    public static void main(String[] args) {
         int  arr[] = {12, 11, 13, 5, 6, 7};

        //merge_sort ob = new merge_sort();
        sort(arr, 0 , arr.length-1);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    static void  sort(int arr[], int s ,int  end ){
        
        if(s<end){

            int mid = (s+(end-s))/2;

            // call sort
            sort(arr,s, mid);
            sort(arr,mid+1,end);

            //merge
            merge(arr , s,mid ,end);
        }
    }

    static void merge(int arr[], int s , int mid , int end ){
        int size1 = mid - s+1;
        int size2 = end -mid;
        
        int L[] = new int[size1];
        int R[] = new int[size2];

        //copy data to temp array
        for (int i = 0; i < arr.length; i++) {
            L[i] = arr[s+i];
        }
        for (int j = 0; j < arr.length; j++) {
            R[j] = arr[mid+1+j];
        }

        int i =0, j = 0;
        int k = s;
        while(i<size1 && j<size2){

            if(L[i]<= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;

        }

        //cpy element of L if left any
        while(i<size1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<size2){
            arr[k] = R[j];
            j++;
            k++;
        }


    }
    

}