package leetCode.array_04;

import java.util.HashMap;

public class M_560_SubarraySumEqualsK {


    public static int subarraySum(int[] nums, int k) {

        int res = 0;
        int sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, -1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

}
