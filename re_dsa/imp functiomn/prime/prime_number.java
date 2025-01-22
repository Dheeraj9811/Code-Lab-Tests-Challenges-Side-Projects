// import FastReader;

import java.util.Scanner;
import java.io.PrintWriter;

public class prime_number {
    static PrintWriter out=new PrintWriter(System.out);

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner st = new Scanner(System.in);
        
        int n = st.nextInt();
        boolean[] arr = prime(n);
        for(int i=0;i<=n;i++){
            if(arr[i]){
                out.print(i+" ");
            }
        }
        out.println();
        out.flush();
        out.close();
        st.close();
    }
    
    // write a function which will return boolean array of prime numbers till n
    static boolean[] prime(int n){
        boolean[] arr = new boolean[n+1];
        for(int i=0;i<=n;i++){
            arr[i] = true;
        }
        arr[0] = false;
        arr[1] = false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(arr[i]){
                for(int j=i*i;j<=n;j+=i){
                    arr[j] = false;
                }
            }
        }
        return arr;
    }
    
     
}
