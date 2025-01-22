public class LongestRegex {
    public static String findLongestRegex(String a, String b, String c) {
        int n = a.length();
        String[][] dp = new String[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = "";
                } else {
                    dp[i][j] = "";
                    if (i > 0) {
                        dp[i][j] = dp[i - 1][j] + a.charAt(i - 1);
                    }
                    if (j > 0) {
                        String temp = dp[i][j - 1] + b.charAt(j - 1);
                        if (temp.compareTo(dp[i][j]) > 0) {
                            dp[i][j] = temp;
                        }
                    }
                    if (c.startsWith(dp[i][j])) {
                        dp[i][j] = "";
                    }
                }
            }
        }

        String result = "";
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (dp[i][j].length() > result.length()) {
                    result = dp[i][j];
                }
            }
        }

        if (result.isEmpty()) {
            return "-1";
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        String a = "AB";
        String b = "BD";
        String c = "CD";
        String result = findLongestRegex(a, b, c);
        System.out.println(result);
    }
}
