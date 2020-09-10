package leetCode.greedy_16;

/**
 *
 * greedy 思想
 * Time: O(n)
 * Space: O(1)
 * You can assume that you can always reach the last index.
 *
 */
public class H_045_JumpGameII {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        int curMaxArea = 0;
        int maxNext = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxNext = Math.max(maxNext, i + nums[i]);
            if (i == curMaxArea) {
                res++;
                curMaxArea = maxNext;
            }
        }
        return res;
    }

    /**
     * BFS解法
     * Time: O(n)
     * Space:O(1)
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int level = 0;
        int curMaxArea = 0;
        int maxNext = 0;
        int i = 0;
        while (curMaxArea - i + 1 > 0) {
            level++;
            for (; i <= curMaxArea; i++) {
                maxNext = Math.max(maxNext, nums[i] + i);
                if (maxNext >= nums.length - 1) {
                    return level;
                }
            }
            curMaxArea = maxNext;
        }
        return 0;
    }

}


