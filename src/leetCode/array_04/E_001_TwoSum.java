package leetCode.array_04;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Time:O(n) 遍历了一边
 * Space: O(n)用了map
 */
public class E_001_TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        if(nums == null || nums.length < 2) {
            return new int[] {-1, -1};
        }

        int[] res = new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if(map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);


        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

}
