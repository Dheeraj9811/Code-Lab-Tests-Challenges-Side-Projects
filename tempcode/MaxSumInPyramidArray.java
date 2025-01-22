import java.util.*;

public class MaxSumInPyramidArray {
    static int[][] dp;
    public static int findMaxSum(int[] pyramid) {
        int n = pyramid.length;

        dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        if (pyramid == null || pyramid.length == 0) {
            return 0; // Return 0 if array is empty or null
        }

        return findMaxSumHelper(pyramid, 0, 0);
    }

    private static int findMaxSumHelper(int[] pyramid, int index, int level) {
        if (index >= pyramid.length) {
            return 0; // Return 0 if reached the end of the pyramid
        }

        if (dp[level][index] != -1) {
            return dp[level][index];
        }
        
        int leftSum =  pyramid[index]+ findMaxSumHelper(pyramid, index + level + 1, level + 1);
        int rightSum =  pyramid[index]+ findMaxSumHelper(pyramid, index + level + 2, level + 1);

        // Choose the maximum sum and return
        return dp[level][index] =  Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        int[] pyramidArray = {1,3,-1,3,1,5}; 
        int maxSum = findMaxSum(pyramidArray);
        System.out.println("Maximum sum in the pyramid array: " + maxSum);
    }
}
