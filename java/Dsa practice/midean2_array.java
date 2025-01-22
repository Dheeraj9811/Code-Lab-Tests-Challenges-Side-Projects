public class midean2_array{// bettary way is ti make io\one array using merge sort 
    static public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int t = nums1.length+nums2.length;
        int a = nums1.length;
        int b = nums2.length;
        int i = 0 ,j = 0;
        double store = 0 ;
        int count = 1;
        int k = t%2==0 ? (t+2)/2 : (t+1)/2;
        while(count<= k && i<a && j<b){
            if(nums1[i]< nums2[j] && i < a ){
                if(t%2 == 0 && (count == t/2 || count == (t+2)/2 )){
                    store = store+nums1[i];
                    count++;
                    
                    i++;
                }else if (t%2 != 0 && count == (t+1)/2 ){
                    store = nums1[i];
                    count++;
                    
                    i++;
                }else{
                    count++;
                    
                        i++;
                }
               
            }else{
                if(t%2 == 0 && (count == t/2 || count == (t+2)/2 )){
                    store = store+nums2[j];
                    count++;
                    j++;
                }else if (t%2 != 0 && count == (t+1)/2 ){
                    store = nums2[j];
                    count++;
                    j++;
                }else{
                    count++;
                    if(j<b)
                        j++;
                }
                
                

            }
        }
        if(i>=a){
            while(count<= k){
                if(t%2 == 0 && (count == t/2 || count == (t+2)/2 )){
                    store = store+nums2[j];
                    count++;
                    j++;
                }else if (t%2 != 0 && count == (t+1)/2 ){
                    store = nums2[j];
                    count++;
                    j++;
                }else{
                    count++;
                    if(j<b)
                        j++;
                }
            }

        }
        if(j>=b){
            while(count<=k){
                if(t%2 == 0 && (count == t/2 || count == (t+2)/2 )){
                    store = store+nums1[i];
                    count++;
                    
                    i++;
                }else if (t%2 != 0 && count == (t+1)/2 ){
                    store = nums1[i];
                    count++;
                    
                    i++;
                }else{
                    count++;
                    
                        i++;
                }
            }

        }
        
        double answer  = (t%2 == 0 ? store/2 : store );
        return answer;
    }
    public static void main(String[] args) {
        int[] a = {1 ,4,6 };
        int[] b = {2,3,5};
        System.out.println(findMedianSortedArrays(a, b)); 
    }
}