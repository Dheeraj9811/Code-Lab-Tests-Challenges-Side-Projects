public class no_ofways {
    
    public static void main(String[] args) {
        System.out.println(no_of_jumps(4));
    }

    static int no_of_jumps(int n){
        
        if(n<0){
            return 0;
        }
        if(n==0)
            return 1;

        return no_of_jumps(n-1) +  no_of_jumps(n-2) +  no_of_jumps(n-3);
    }
}
