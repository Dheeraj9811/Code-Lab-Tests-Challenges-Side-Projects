public class Binaray_sarch {
   
   static int Bs(int [] arr , int key , int size){
       int l = size -1;
        int s = 0;
       int mid = (l+s)/2;
       while(key != arr[mid] && s<=l){
            mid = (l+s)/2;
           if(key == arr[mid])
                return mid;
            else if(key<arr[mid]){
                l = mid-1;
            }else{
                s = mid+1;
            }

       }
       return -1;

    }

    static int recursiveB_s(int [] arr , int key , int s , int l){ // here l = size -1 
        
        if(s<=l){
            int mid = (l+s)/2;
            if(key == arr[mid])
                return mid;
            else if(key<arr[mid]){
                l = mid-1;
                return recursiveB_s(arr, key, s, l);
            }else{
                s = mid+1;
                return recursiveB_s(arr, key, s, l);
            }
        }
        return - 1 ;
        
    }
    public static void main(String[] args) {
        int [] A = {1,5,10,12,13,14,16,21,25,26};
        System.out.println(Bs(A, 12, 10));
        System.out.println(recursiveB_s(A, 1, 0, 10-1));

    }
}
