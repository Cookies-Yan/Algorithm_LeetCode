package leetCode.dynamic_18;

import java.util.Arrays;

public class M_322_CoinChange {

    /**
     * Time O(n*m^2)
     * Space O(mn)
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[][] f = new int[coins.length + 1][amount + 1];
        Arrays.fill(f[coins.length], Integer.MAX_VALUE);
        f[coins.length][0] = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 0; j <= amount; j++) {
                f[i][j] = f[i + 1][j];
                int maxK = j / coins[i];
                for (int k = 1; k <= maxK; k++) {
                    int prev = f[i + 1][j - k * coins[i]];
                    if (prev < Integer.MAX_VALUE) {
                        f[i][j] = Integer.min(f[i][j], prev + k);
                    }
                }
            }
        }
        return f[0][amount] == Integer.MAX_VALUE ? -1 : f[0][amount];
    }
    /**
     * Time O(n * amount)
     * Space O(amount)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins == null || coins.length == 0) return -1;

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]]+ 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange(coins,11));
    }
}
