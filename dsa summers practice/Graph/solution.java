import java.util.HashMap;
import java.util.HashSet;

public class solution {
    int solve(int a[],int S){
        int n = a.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int runningSum = 0;
        int res=0;
        for(int i=0;i<n;i++){
            runningSum += a[i];
            final int key = runningSum - (S * (i + 1));
            res += map.getOrDefault(key,0);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        return res;
    }
}
