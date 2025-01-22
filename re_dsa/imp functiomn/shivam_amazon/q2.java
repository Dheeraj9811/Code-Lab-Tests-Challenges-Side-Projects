import java.util.*;

public class q2 {

    int solve(int arr[], int power[]){
        // prefix sum
        int n = arr.length;
        int m = power.length;
        
        Arrays.sort(power);

        // prefix sum with mod 10^9+7
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        for(int i = 1;i<n;i++){
            prefix[i] = (prefix[i-1]%1000000007 + arr[i]%1000000007)%1000000007;
        }
        int ans = 0;
        
        // System.out.println(p);
        for(int i = 0;i<m/2;i++){
        
            int first = power[i];
            int second = power[m-1-i];
            

            int sum = prefix[second] - prefix[first]+arr[first];
            
            ans = (ans%1000000007 + sum%1000000007)%1000000007;
            

        }
        return ans;
    }

    
    public static void main(String[] args) {
        int arr[] = {3,5,6,0,7};
        int power[] = {3,1,0,2 }; // 0 1 2 3
        // int k = 4;
        q2 obj = new q2();
        System.out.println(obj.solve(arr,power));
    
    }
}
