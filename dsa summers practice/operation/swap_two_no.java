public class swap_two_no {

    static String swap(String a , String b){
        
        // string to long
        long x = Long.parseLong(a);
        long y = Long.parseLong(b);

        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        
        
        
        // return a and b in string format
        return (Long.toString(x) + " " + Long.toString(y));
    }

    // find the ith bit of number n
    public static int find_bit(long n, int i){
        return (int) ((n & (1 << i)) != 0 ? 1 : 0);
    }

    public static long setone(Long n, int i){
        return ((long) (n | (1 << i)));
    }
    public static long setzero(Long n, int i){
        return ((long) (n & ~(1 << i)));
    }

    public static void main(String[] args) {
        String a = "21";
        System.out.println(swap(a, "4"));
        System.out.println(find_bit(5, 4));

        // #print in binary format
        System.out.println(Long.toBinaryString(setone((long) 5,1)));
        System.out.println((setone((long) 5,1)));

        System.out.println(Long.toBinaryString(setzero((long) 5,2)));
        System.out.println((setzero((long) 5,2)));
        
    }

}
