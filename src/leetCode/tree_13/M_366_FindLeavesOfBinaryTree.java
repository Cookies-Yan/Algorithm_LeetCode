package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Time O(n)
//Space O(h)
public class M_366_FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    public int helper(List<List<Integer>> res, TreeNode root) {
        if (root == null) return -1;
        int left = helper(res, root.left);
        int right = helper(res, root.right);
        int level = Math.max(left, right) + 1;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
    }
}
