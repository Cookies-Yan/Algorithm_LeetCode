package leetCode.tree_13;

public class E_543_DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Time O(n)
     * Space O(n)
     */
    //左子树的最大深度 + 右子树的最大深度 = 最大的树的直径， 后序遍历
    // Length of longest path which pass it = MaxDepth of its left subtree + MaxDepth of its right subtree
    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }

}
