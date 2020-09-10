package leetCode.array_04;

public class E_053_MaximumSubArray {
    /**
     * dp
     * Time:O(n)
     * Space: O(n)
     */
    public int maxSubArray(int[] nums) {

        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    /**
     *greedy
     *Time O(n)
     *Space O(1)
     */
    public int maxSubArray2(int[] nums) {
        int sum = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            res = Math.max(res, sum);
        }

        return res;

    }
}
