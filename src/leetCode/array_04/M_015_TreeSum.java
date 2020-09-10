package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time:O(n^2)
 * Space:O(n)
 */
public class M_015_TreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        //Two pointer 一前一后
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue; //去除重复
            int low = i + 1;
            int high = nums.length - 1;
            int sum = 0 - nums[i];

            //此后跟twoSum差不多
            while (low < high) {
                if(nums[low] + nums[high] == sum) {
                    /**
                     * Arrays.asList 将一个数组转换为 List 以便进行更丰富的操作
                     */
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    //去重
                    while(low < high && nums[low] == nums[low + 1]) low++;
                    //去重
                    while(low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if(nums[low] + nums[high] < sum) {
                    low++;
                } else {
                    high--;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new ArrayList<>();
        res = threeSum(nums);
        System.out.println(res);
    }
}
