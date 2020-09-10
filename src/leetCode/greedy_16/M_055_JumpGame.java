package leetCode.greedy_16;

public class M_055_JumpGame {
    /**
     * 贪心的思想,跳的最大距离可以到最后，就可以
     * 如果连i都跳不过去的话，就肯定不能到达终点
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < max) return false;
            Math.max(nums[i] + i, max);
        }
        return true;
    }
}
