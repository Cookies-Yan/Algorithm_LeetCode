package leetCode.dynamic_18;

import java.util.Arrays;

public class M_300_LongestIncreasingSubsequence {

    /**
     * 数组方法解决
     * Time O(nlogn)
     * Space O(n)
     *
     * [10, 9, 2, 5, 3, 7, 101, 18]
     *
     * res = size
     * 10 res = 0 i = 0 j = 0
     * 9  res = 1 i = 0 j = 1 mid = 0 --> j = 0
     * 2  res = 1 i = 0 j = 1 mid = 0 --> j = 0
     * 5  res = 1 i = 0 j = 1 mid = 0 --> i = 1
     * 3  res = 2 i = 1 j = 2 mid = 1 --> j = 1
     * 7  res = 2 i = 1 j = 2 mid = 1 --> i = 2
     * 101 res = 3 i = 2 j = 3 mid = 2 --> i = 3
     * 18 res = 4 i = 3  j = 4 mid = 3 --> j = 3
     *
     * i, j相当于tails的起点，终点
     * tails = [2, 5, 7, 18] 最后虽然101被 18 替换了 但是我们只需要知道size，所以不影响结果
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            int i = 0;
            int j = size;
            while (i != j) {
                int mid = (i + j) / 2;
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (i == size) {
                size++;
            }
        }
        return size;
    }

    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        /**
         * length加不加1，看0位置有没有用
         * DP 方法解决
         *   0, 1, 2, 3, 4, 5,  6,  7
         * [10, 9, 2, 5, 3, 7, 101, 18]
         *
         * i = 1, j = 0, 9 !> 10
         *
         * i = 2, j = 0, 2 !> 10
         *        j = 1, 2 !> 9
         *
         * i = 3, j = 0, 5 !> 10
         *        j = 1, 5 !> 9
         *        j = 2, 5  > 2   dp[3] = max(dp[3], dp[2] + 1) = 2
         *
         * i = 4  j = 0, 3 !> 10
         *        j = 1, 3 !> 9
         *        j = 2, 3  > 2   dp[4] = max(dp[4], dp[2] + 1) = 2
         *        j = 3, 3 !> 5
         *
         * i = 5  j = 0, 7 !> 10
         *        j = 1, 7 !> 9
         *        j = 2, 7  > 2   dp[5] = max(dp[5], dp[2] + 1) = 2
         *        j = 3, 7  > 5   dp[5] = max(dp[5], dp[3] + 1) = 3
         *        j = 4, 7  > 3   dp[5] = max(dp[5], dp[4] + 1) = 3
         *
         * i = 6  j = 0, 101> 10  dp[6] = max(dp[6], dp[0] + 1) = 2
         *        j = 1, 101> 9   dp[6] = max(dp[6], dp[1] + 1) = 2
         *        j = 2, 101> 2   dp[6] = max(dp[6], dp[2] + 1) = 2
         *        j = 3, 101> 5   dp[6] = max(dp[6], dp[3] + 1) = 3
         *        j = 4, 101> 3   dp[6] = max(dp[6], dp[4] + 1) = 3
         *        j = 5, 101> 7   dp[6] = max(dp[6], dp[5] + 1) = 4
         *
         * i = 7  j = 0, 18 > 10  dp[7] = max(dp[7], dp[0] + 1) = 2
         *        j = 1, 18 > 9   dp[7] = max(dp[7], dp[1] + 1) = 2
         *        j = 2, 18 > 2   dp[7] = max(dp[7], dp[2] + 1) = 2
         *        j = 3, 18 > 5   dp[7] = max(dp[7], dp[3] + 1) = 3
         *        j = 4, 18 > 3   dp[7] = max(dp[7], dp[4] + 1) = 3
         *        j = 5, 18 > 7   dp[7] = max(dp[7], dp[5] + 1) = 4
         *        j = 6, 18!> 101
         *
         *       0, 1, 2, 3, 4, 5, 6, 7
         * dp = [1, 1, 1, 2, 2, 3, 4, 4]
         *
         *
         */
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
