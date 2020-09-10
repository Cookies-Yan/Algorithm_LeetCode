package leetCode.tree_13;


public class M_098_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return helper(root, null, null);
    }
    //在不知道左边右边值的情况下，先赋值null
    public static boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    private class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
