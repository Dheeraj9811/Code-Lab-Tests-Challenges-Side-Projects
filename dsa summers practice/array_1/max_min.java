public class max_min{
    // its is merge sort typeee  method which we have used time O(nlogn) space O(n)
    static class Pair{
        int min , max;
    }

    static Pair compare(int arr[] ,int low, int n){
        Pair maxmin = new Pair();
        Pair lmn = new Pair();
        Pair Rmn = new Pair();

        int mid ;

        
        int heigh = n;

        if(low == heigh ){
            maxmin.max= arr[low-1];
            maxmin.min=arr[low-1];
            return maxmin;
        }

        if(low+1 ==  heigh){
            if(arr[low-1] > arr[heigh-1] ){
                maxmin.max = arr[low-1];
                maxmin.min = arr[heigh-1];
            }else
            {
                maxmin.max = arr[heigh-1];
                maxmin.min = arr[low-1]; 
            }

            return maxmin;
        }
        else
        {
            mid = (heigh+low)/2;
            // comparing left side half
            lmn = compare(arr, low, mid);
            // comparing right side half
            Rmn = compare(arr, mid+1, heigh);
            

            // compare both lmn and rmn max and min
            if(lmn.min <= Rmn.min){
                maxmin.min = lmn.min;
            }else
            {
                maxmin.min = Rmn.min;
            }

            if(lmn.max >= Rmn.max){
                maxmin.max = lmn.max;
            }else
            {
                maxmin.max = Rmn.max;
            }

            return maxmin;
        }


    }

    public static void main(String[] args) {
        int arr[] = {1000, 11, 445, 1, 330, 3000}; 
        int arr_size = 6;
        Pair maxmin = compare(arr, 1, arr_size);
        System.out.printf("\nMinimum element is %d", maxmin.min);
        System.out.printf("\nMaximum element is %d", maxmin.max);
    }
}