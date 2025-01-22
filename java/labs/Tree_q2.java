import java.util.Scanner;

public class Tree_q2 {
    
    static public int noOfTree(int n ){
        int count = 0;
        if(n<=1){
            return 1 ;

        }
        else{
            for (int i = 0; i < n; i++) {
                count = count +noOfTree(i)*noOfTree(n-1-i);
                
            }
            return count;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            input.nextInt();
        }

        System.out.println(noOfTree(n));
        
    }
}
