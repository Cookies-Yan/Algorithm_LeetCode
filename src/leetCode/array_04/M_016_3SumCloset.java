package leetCode.array_04;

import java.util.Arrays;

/**
 * 去重：排序
 * 降维
 * for 循环 + two sum
 * 很少考
 * Time O(n ^ 2)
 * Space O(1)
 */
public class M_016_3SumCloset {

    public static int threeSunm(int[] nums, int target) {

        int res = nums[0] + nums[1] + nums[nums.length - 1]; //随便找三个在数组中的数相加
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum < target) {
                    start++;
                } else {
                    end--;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSunm(nums, target));
    }
}
