package leetCode.array_04;

import java.util.Arrays;

/**
 * Time O(n^2)
 * Space O(1)
 */
public class M_259_ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < target) {
                    count += end - start; // 只要小于，end随便往左移动，都是小于
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }
}
