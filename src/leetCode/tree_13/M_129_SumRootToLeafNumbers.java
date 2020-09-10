package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

public class M_129_SumRootToLeafNumbers {
    //Time O(n)
    //Space O(h)
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int num) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }
        return helper(root.left, num * 10 + root.val) + helper(root.right, num * 10 + root.val);
    }
}
