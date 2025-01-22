public class reverse_bit {
	static public long reverse(long a) {
        long ans = 0;

        while(a!=0){
            int i = (int) (Math.log(a&(-a))/Math.log(2));
            a = (a & (a-1));
            // int temp = ((a & (1<<i)) !=0 ? 1 :0);
            
            ans = (ans  | (1L<<32-i-1));
            System.out.println(Long.toBinaryString(i));
            System.out.println(Long.toBinaryString(ans) + " " + ans);
        }
        // System.out.println(Long.toBinaryString(a));
        // System.out.println(Long.toBinaryString(ans));
        return  ans;
	}

    public static void main(String[] args) {
        System.out.println( reverse(3));
        // int ans = 0;
        // ans = (ans  | (1<<32-1));
        // System.out.println(Long.toBinaryString(1));
    
        
    }
}
