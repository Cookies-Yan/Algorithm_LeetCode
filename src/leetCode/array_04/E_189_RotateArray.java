package leetCode.array_04;

public class E_189_RotateArray {

    /**
     * 自己的的方法
     * Time O(n)
     * Space O(n)
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        k = k % nums.length;
        int j = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (k != 0) {
                temp[i] = nums[len - k];
                k--;
            } else {
                temp[i] = nums[j++];
            }
        }
        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
    }

    /**
     * Time O(n)
     * Space O(n)
     * [1, 2, 3, 4, 5, 6, 7]
     *           1, 2, 3, 4
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            temp[(i + k) % len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length- 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
