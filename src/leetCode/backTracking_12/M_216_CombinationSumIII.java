package leetCode.backTracking_12;

import java.util.ArrayList;
import java.util.List;

/**
 * Time O(2 ^ n)
 * Space O(n)
 */
public class M_216_CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0 || k > 9) return res;
        helper(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(res, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
