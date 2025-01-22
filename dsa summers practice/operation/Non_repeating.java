

public class Non_repeating {
    
    public static void find(int[] arr){
        int ans = 0;
        

        
        for(int i = 0 ; i < arr.length ; i++){
            ans = ans^arr[i];
        }
        
        //  finding first set bit using ans & -ans
        int temp = ans;
        // System.out.println(ans);
        // here we get a mask where first bit is 1 others bits = 0 eg: 00000100 (2nd bit is one )
        temp = (temp & (-temp));
        //  if we do and with this mask we can sperate in two buckets 
        int ans1 = ans;
        for (Integer integer : arr) {
            if((temp & integer) > 0){
                
                ans = ans^integer; // bucket one where set bit = ans set bit
                
            }
            else{
                ans1 = ans1^integer;
            
                
            }
            
        }

        System.out.println(ans + " "+ ans1);
        
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,1,2,3,4,6,7};
        find(arr);


    }
}
