package leetCode.backTracking_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M_090_SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums); //不sort不能判断 nums[i] == nums[i - 1]
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list)); //一开始是为空的，也是subset所以先把控制加进去
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue; //加sort的原因
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);
        for (List<Integer> list :  res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
