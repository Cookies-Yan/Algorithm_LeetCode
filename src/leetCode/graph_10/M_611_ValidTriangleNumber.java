package leetCode.graph_10;

import java.util.Arrays;

public class M_611_ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int start = 0;
            int end = i - 1;

            while (start < end) {
                if (nums[start] + nums[end] <= nums[i]) {
                    ++start;
                    continue;
                }
                res += (end - start);
                end--;
            }
        }
        return res;
    }

}
