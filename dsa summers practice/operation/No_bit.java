public class No_bit {
    // no. of bits is 1 
    public static int  bits(int n){
        int count = 0;
        while(n!=0){
            System.out.println(Integer.toBinaryString(n));
            n = (n & (n-1));
            // System.out.println(Integer.toBinaryString(n));
            count++;
        }
        return count;
    }

    
    public static void main(String[] args) {
        int a = 20;
        // int b = 4;
        // print in binary format
        // System.out.println(Integer.toBinaryString(a));
        System.out.println(bits(a));
        // call bits function fromk above
        
        
    }    
}
