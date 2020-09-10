package leetCode.backTracking_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time: O(n * 2^n)
 * Space: O(n * 2^n)
 */
public class M_078_Subsets {

    /**
     * 剪枝DFS
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        //因为list是一个一直改变的变量，所以需要做一个deep copy去吧数组加到res里面
        res.add(new ArrayList<>(list)); //一开始是为空的，也是subset所以先把控制加进去
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> list :  res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
