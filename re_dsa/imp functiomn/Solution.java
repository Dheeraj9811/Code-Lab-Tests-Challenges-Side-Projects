import java.util.Arrays;

public class Solution {

    public static int minTimeToTransferSubsequence(int[] arr, int M) {
       int n = arr.length;
    if (M > n) {
        return -1; // Error: subsequence of size M does not exist in the array
    }
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    int i = 0, j = 0;
    while (j < n) {
        if (arr[j] < min1) {
            min2 = min1;
            min1 = arr[j];
        } else if (arr[j] < min2) {
            min2 = arr[j];
        }
        if (j - i + 1 == M) {
            return min1 * min2; // Found subsequence of size M with smallest product
        }
        j++;
        if (j - i + 1 > M) {
            if (arr[i] == min1) {
                min1 = min2;
            }
            i++;
        }
    }
    return -1; // Error: subsequence of size M does not exist in the array

    }

   

    public static void main(String[] args) {
        int[] Arr = {7,3,8,10,1,12};
        int M = 4;
        int result = minTimeToTransferSubsequence(Arr, M);
        System.out.println("Minimum time to transfer subsequence of size " + M + ": " + result);
    }
}
