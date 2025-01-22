package shivam_amazon;

import java.util.HashMap;
import java.util.Map;

public class sumDivbyK {
    public static long countPairs(int[] A, int K) {
        Map<Integer, Integer> m = new HashMap<>();
        long ans = 0;
        
        for (int i = 0; i < A.length; i++) {
            int rem1 = A[i] % K;
            if (rem1 != 0)
                ans += m.getOrDefault(K - rem1, 0);
            else
                ans += m.getOrDefault(0, 0);
            
            m.put(rem1, m.getOrDefault(rem1, 0) + 1);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {31,25,85,29,35};
        int k = 60;
        System.out.println(countPairs(arr, k));
    }
}
