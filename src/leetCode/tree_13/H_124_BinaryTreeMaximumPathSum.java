package leetCode.tree_13;

public class H_124_BinaryTreeMaximumPathSum {

    /*后序遍历*/
    //Time O(n)
    //Space O(n)
    int res;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        /**
         * res 和 return的值是不一样的，return的是左子树或者右子树的最大分支的结果，res是整个子树的和。
         */
        if (root == null) return 0;
        //0来处理负数的情况，如果是负数就摒弃
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    class TreeNode {
        TreeNode left;

        TreeNode right;

        public int val;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
