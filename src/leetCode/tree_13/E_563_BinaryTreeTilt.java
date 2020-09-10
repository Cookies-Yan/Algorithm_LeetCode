package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

public class E_563_BinaryTreeTilt {
    /*后续遍历*/
    //Time O(n)
    //Space O(n)
    int res = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res += Math.abs(left - right);
        return left + right + root.val; //最后的值并不放到最后的结果里面
    }
}
