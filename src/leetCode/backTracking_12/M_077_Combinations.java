package leetCode.backTracking_12;

import java.util.ArrayList;
import java.util.List;

/**
 * time: O(k * C(n,k))
 * Space: O(k * C(n,k))
 * 组合
 */
public class M_077_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        //因为题目是1 - n数字，不是像数组一样的
        helper(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(res, list, n, k - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
