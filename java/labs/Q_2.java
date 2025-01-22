import java.util.Scanner;

public class Q_2 {
    int minJumpsToReachEnd(int arr[], int l, int h) {
        if (h == l)
            return 0;

        if (arr[l] == 0)
            return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
            int jumps = minJumpsToReachEnd(arr, i, h);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
                min = jumps + 1;
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        Q_2 obj = new Q_2();
        Integer ans = obj.minJumpsToReachEnd(arr,0,n-1);
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }
        
    }
    
}
