import java.util.Scanner;

public class DistinctArrays {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Length of array S
            int[] S = new int[N];

            for (int i = 0; i < N; i++) {
                S[i] = scanner.nextInt();
            }

            int[] A = new int[N];
            count = 0; // Reset count for each test case

            generateArrays(A, 0, S);
            System.out.println("Test Case #" + (t + 1) + ": " + count);
        }

        scanner.close();
    }

    private static void generateArrays(int[] A, int index, int[] S) {
        if (index == A.length) {
            if (checkCondition(A))
                count++;
            return;
        }

        for (int digit = 1; digit <= 9; digit++) {
            A[index] = digit;
            generateArrays(A, index + 1, S);
            A[index] = 0; // Backtrack
        }
    }

    private static boolean checkCondition(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] >= A[i + 1])
                return false;
        }
        return true;
    }
}
