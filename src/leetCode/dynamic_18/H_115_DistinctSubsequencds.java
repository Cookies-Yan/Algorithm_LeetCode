package leetCode.dynamic_18;

public class H_115_DistinctSubsequencds {

    /**
     * Time O(m * n)
     * Space O(m * n)
     * @param s
     * @param t
     * @return
     *
     * int[][] dp
     *
     * 1. s.charAt(i) != t.charAt(j)
     *    dp[i][j] = dp[i - 1][j]
     * 2. s.charAt(i) == t.charAt(j)
     *    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]
     *
     *        r  a  b  b  i  t
     *     1, 0, 0, 0, 0, 0, 0
     *   r 1, 1, 0, 0, 0, 0, 0
     *   a 1, 1, 1, 0, 0, 0, 0
     *   b 1, 1, 1, 1, 0, 0, 0
     *   b 1, 1, 1, 2, 1, 0, 0
     *   b 1, 1, 1, 3, 3, 0, 0
     *   i 1, 1, 1, 3, 3, 3, 0
     *   t 1, 1, 1, 3, 3, 3, 3
     *
     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
