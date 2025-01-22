//  number is repeating k times find the number which is non repeating
//  dont work for negative number
public class K_times_repeating {

    static void find(int[] arr){
        // assuing interger is of 32bit only
        int[] bits_arr = new int[32];
        // System.out.println(bits[19]);
        for(int i = 0 ; i < arr.length;i++){
            for(int j=0 ; j< bits_arr.length;j++){
                // postion is one or not , if one count +1 in bits arrays
                if((arr[i] &(1<<j)) >0){
                    bits_arr[j] += 1;

                }
            }
            // System.out.println("arr value:"+ arr[i]);
            
        }
        
        String ans = "";
        for (int i = bits_arr.length-1; i >=0 ; i--) {
            if(bits_arr[i] % 3 != 0)
                ans += "1";
            else
                ans += "0";
        }
        
        System.out.println(Integer.parseInt(ans, 2));
    }

    static void try_2(int[] arr){
        
        int ans = 0;

        for(int i =0; i< 32 ; i++ ){
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if((arr[j] & (1<<i)) != 0 ){
                    count++;
                }

            }

            if(count%3 != 0){
                ans = ans|(1<<i);
                
            }
        }

        System.out.println(ans);
    }

        

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,3,3,3,4,4,4,5,6,6,6,7,7,7};
        find(arr);
        String a = "21";
        // Time Complexity : O(32 N) time complexity will be O(N) because the outer loop is running for constant time i.e. for only 32 times...
        
        // Space Complexity : O(1)
        try_2(arr);
        // take 3 integer number user 
        
        

    }
}
