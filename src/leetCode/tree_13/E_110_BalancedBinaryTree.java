package leetCode.tree_13;

public class E_110_BalancedBinaryTree {

    /*后序遍历*/
    // Time O(n)
    // Space O(n)
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return helper(root) != -1;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        //-1是因为 有时候没有回溯到根节点的时候节已经不平衡了，利用-1向上传递信号
        if(l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }

    private class TreeNode {

        TreeNode left;

        TreeNode right;

        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
