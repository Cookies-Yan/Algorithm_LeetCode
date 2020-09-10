package leetCode.backTracking_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M_047_PermutationsII {
    /**
     * Time O(n! * n)
     * Space O(n)
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums); //去重就要排序
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue; // i = 0 没有执行
            used[i] = true;
            list.add(nums[i]);
            helper(res, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
    /**
     * Time O(n!)
     * Space O(n)
     */
    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums); //去重就要排序
        helper2(res, nums, 0);
        return res;
    }

    public void helper2(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (isUsed(nums, start, i)) continue;
            swap(nums, start, i);
            helper2(res, nums, start + 1);
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public boolean isUsed(int[] nums, int i, int j) {
        for (int x = i; x < j; x++) {
            if (nums[x] == nums[j]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        permuteUnique(nums);

    }

}
