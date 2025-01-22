public class odd_even {
    
    // return string function
    public static String find(long n){
        if( (n & 1) == 0)
            return "even";
        else
            return "odd";
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // type cast to long
        System.out.println(find((long) 25));
        
    }

}
