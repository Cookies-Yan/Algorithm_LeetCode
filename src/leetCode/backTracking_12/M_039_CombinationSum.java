package leetCode.backTracking_12;

import java.util.ArrayList;
import java.util.List;

public class M_039_CombinationSum {
    /**
     * Time O(2^n)
     * Space O(n)
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }


    public static void helper(List<List<Integer>> res, List<Integer> list,
                              int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list)); //必须要new 因为还要用这个list去修改和remove等操作
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] c = {2,3,6,7};
        combinationSum(c, 7);
    }

}
