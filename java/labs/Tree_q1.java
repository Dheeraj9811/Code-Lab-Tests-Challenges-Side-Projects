import java.util.Scanner;



public class Tree_q1 {
    static public long Fac(int n){
        long result = 1;
        if(n == 0)
            return 1;
        else{
            while(n>1){
                result = result*n;
                n--;
            }
        }   return result;
    }

    static public long noOfTree(int n ){
        long count = Fac(2*n)/(Fac(n+1)*Fac(n));
        return count;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            input.nextInt();
        }

        if(n == 0 )
        System.out.println(n);
        else{
        System.out.println(noOfTree(n));
        }
    }
    
}
