package leetCode.tree_13;

import java.util.ArrayList;
import java.util.List;

/**
 * preorder + 回溯
 */
public class M_113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, new ArrayList<>(), root, sum);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<>(list));
            }
        }
        helper(res, list, root.left, sum - root.val);
        helper(res, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }

    private static class TreeNode {

        TreeNode left;

        TreeNode right;

        int val;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
