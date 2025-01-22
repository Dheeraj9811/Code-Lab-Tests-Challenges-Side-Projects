public class MaxMatrixMultiplicationCount {
    public static int maxMatrixMultiplicationCount(int[] dimensions) {
        int n = dimensions.length - 1;
        int[][] dp = new int[n][n];

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MIN_VALUE;

                for (int k = i; k < j; k++) {
                    int count = dp[i][k] + dp[k + 1][j] - 1; // Subtract 1 since we are removing one matrix
                    if (count > dp[i][j]) {
                        dp[i][j] = count;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] matrixDimensions = {2,4,1,3,4,6,2,4,1,6};
        i
        int maxCount = maxMatrixMultiplicationCount(matrixDimensions);
        System.out.println("The maximum count of matrix multiplications by removing matrices: " + maxCount);
    }
}
