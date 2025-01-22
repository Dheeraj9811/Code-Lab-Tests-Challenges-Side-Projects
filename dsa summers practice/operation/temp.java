import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

    public class temp {
        static Long gdc(Long a , Long b){
            if(b ==0) return a;
            return gdc(b,a%b);
        }
    public static void main(String[] args) throws IOException {
        //  bufferreader to read interger input
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        // // StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(br.readLine());
        // while(n>0){
        //     int num = Integer.parseInt(br.readLine());
        //     int copy = num;
        //     int rev = 0;
        //     while(num>0){
        //         int rem = num%10;
        //         num /= 10;
        //         rev = rev*10 + rem;
        //     }
        //     System.out.println(rev+" "+copy);
        //     if(copy == rev){
        //         System.out.println("wins");
        //     }
        //     else
        //         System.out.println("loses");
        //     n--;
        // }
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int i =Integer.parseInt(br.readLine());
		
		// while(i>0){
        //     int n = Integer.parseInt(br.readLine());
		//     for(int j = n ; j>0;j-- ){
		//         int count =0;
                
		//         if(Integer.parseInt(br.readLine())>=1000){
		//             count++;
		//         }
		//             System.out.println(count);
		//         }
		//     }
		//     i--;

        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// int j = Integer.parseInt(in.readLine());
		// for(int i = j ; i>0;i++){
		//     String[] val = in.readLine().split(" ");
		//     int a = Integer.parseInt(val[0]);
		//     int b = Integer.parseInt(val[1]);
		//     if(b/a <a){
		//         System.out.println((a*b)/a);
		//     }
		//     else
		//         System.out.println((a));
		    
		// }
        // in.re
        // System.out.println(in.read());

        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
        // StringTokenizer st = new StringTokenizer(in.readLine());
        // long n = Long.parseLong(st.nextToken());
        // int k = Integer.parseInt(st.nextToken());
        // int count = 0;
        // System.out.println(n+" "+k);
        // int j = Integer.parseInt(st.nextToken());
        // System.out.println(j);
        // st.
        // while (n-- > 0) {
        //     int x = Integer.parseInt(in.readLine());
        //     if (x % k == 0)
        //         count++;
        // }
        // System.out.println(count);
		// }
        //  declear long varibale
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(in.readLine(),"\n");
        long n = 0L ; 
        long k = 0L;
        int t = 0;
        
            t = Integer.parseInt(st.nextToken());
            
        
        for(int i = 0 ; i<t;i++){
            
            
                //  take input
                st = new StringTokenizer(in.readLine()," ");
                n = Long.parseLong(st.nextToken());
                k = Long.parseLong(st.nextToken());

            
        
            
            // ans = N/(gcd(N,K))
            System.out.println(n/gdc(n,k));
                        
            
        }
        //  insertion sort
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int n = arr.length;
        for(int i = 1 ; i<n;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        for(int i = 0 ; i<n;i++){
            System.out.print(arr[i]+" ");
        }
        
        Long.par
    }
}
