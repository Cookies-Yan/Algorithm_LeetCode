package leetCode.greedy_16;

public class H_330_PatchingArray {

    /**
     * Time O(n)
     * Space O(1)
     * [1, 2, 5, 13, 24]
     *
     * miss:表示[0, n]之间最小的不能表示的值
     * num <= miss => [0, miss + num)
     *
     * nums = [1, 2, 5, 13, 24], n = 50
     *
     * miss = 1
     *
     * 1 : miss = 2
     * 2 : miss = 4
     * 5 : miss = 8 res = 1
     * 5 : miss = 13
     * 13 : miss = 26
     * 24 : miss = 50 res = 2
     *
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        int i = 0;
        int res = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                res++;
            }
        }
        return res;
    }
}
