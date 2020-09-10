package leetCode.backTracking_12;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time O(2^n)
 * Space O(n)
 */
public class M_040_CombinationsSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list,
                       int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            /**
             * 在这里也可以用contain去重，但是很慢， 我们直接用32行去重就可以
             */
            // if (!res.contains(list)) {
            //     res.add(new ArrayList<>(list));
            // }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(i != start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            helper(res, list, candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
