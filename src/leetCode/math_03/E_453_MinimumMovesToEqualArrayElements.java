package leetCode.math_03;

/**
 * Time O(n)
 * Space O(1)
 */
public class E_453_MinimumMovesToEqualArrayElements {
    /**
     *
     * [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
     * 以最小值为基准，让其它数减小到最小值的步数总和
     *         => [1,2,2] => [1,2,1] => [1,1,1]
     * 以前学要移动n-1个元素， 现在只需要移动一个元素
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }

    /**
     * [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
     *
     * len * (min + k) = sum + k * (len - 1)   //k是output, 总体的和是变化过后的数组总和
     *                 ==> k = sum - min * len;     //sum是没变化之前的数组总和
     * @param nums
     * @return
     */
    public int minMoves1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        long sum = 0; //防止越界
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return (int)(sum - min * nums.length);
    }
}
