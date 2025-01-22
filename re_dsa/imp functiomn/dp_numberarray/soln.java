import java.util.Arrays;

class soln {
    static int n , dp[][];
    public int maxValue(int[][] events, int k) {
        n = events.length;
        Arrays.sort(events, (a,b)-> a[0]-b[0] );
        dp = new int[n+1][k+1];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,k,events);
    }
    int solve(int i,int k,int[][] arr){
        if(i == n || k == 0) return 0;
        int sd = arr[i][0] , end = arr[i][1];
        // if(sd <= ed) return solve(i+1,ed,k,arr);
        if(dp[i][k] != -1) return dp[i][k];
        int take = 0;
        int index = nextgreatest(i,end,arr);
        take = arr[i][2] + solve(index,k-1,arr);
        
        int nt = 0 +solve(i+1,k,arr);
        return  dp[i][k] = Math.max(take,nt);
    }
    int nextgreatest(int start,int target,int[][] arr){
        int low = start;
        int high = n -1;
        int ans= n;

        while(low<= high){
            int mid = low+(high-low)/2;
            if(arr[mid][0] == target) low = mid+1;
            else if(arr[mid][0]> target){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;

        }
        return ans;
    }
    public static void main(String[] args) {
        // 2
        // [[1,2,4],[3,4,3],[2,3,10]]
        int[][] arr = {{1,2,4},{3,4,3},{2,3,10}};
        int k = 2;
        System.out.println(new soln().maxValue(arr,k));
    }
}