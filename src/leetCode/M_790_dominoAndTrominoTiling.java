package leetCode;

/**
 * Time: O(n)
 * Space: O(n)
 */
public class M_790_dominoAndTrominoTiling {

    public static int numTilings(int N) {

        if (N <= 0) {

            throw new IllegalArgumentException("N has too be a positive number");

        } else if (N > 1000) {

            throw new IllegalArgumentException("N will be in range[1, 1000]");

        } else {
            int x = 1000000007;
            long[][] dp = new long[N + 1][2];
            dp[0][0] = 1; dp[1][0] = 1;

            for(int i = 2; i <= N; i++) {
                dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + 2 * dp[i - 1][1]) % x;
                dp[i][1] = (dp[i - 1][1] + dp[i -2][0]) % x;
            }
            return (int)dp[N][0];
        }
    }

    public static void main(String[] args) {
        System.out.println(numTilings(10));
    }
}
