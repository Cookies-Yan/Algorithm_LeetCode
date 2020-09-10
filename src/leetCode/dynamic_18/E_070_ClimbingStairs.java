package leetCode.dynamic_18;

public class E_070_ClimbingStairs {

    /**
     * Time O(2^n)
     * Space O(n)
     * 类似于斐波那契数列
     * @param n
     * @return
     */

    // 超时，类似于斐波那契数列
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    /**
     * 记忆化搜索法
     * Time O(n)
     * Space O(n)
     * 如果 n = 6 下面是memo的变化
     * [0, 0, 0, 3, 0, 0, 0]
     * [0, 0, 0, 3, 5, 0, 0]
     * [0, 0, 0, 3, 5, 8, 0]
     * [0, 0, 0, 3, 5, 8, 13]
     */
    public int climbStairs1(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }

    /**
     * DP
     * Time O(n)
     * Space O(n)
     */
    public int climbStairs2(int n) {
        if (n <= 2){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Time O(n)
     * Space O(1)
     * 类似于斐波那契数列
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n <= 1) return 1;
        int oneStep = 1, twoStep = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = res;
        }
        return res;
    }
}
