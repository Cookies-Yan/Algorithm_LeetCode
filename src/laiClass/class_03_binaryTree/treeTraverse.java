package laiClass.class_03_binaryTree;

public class treeTraverse {
    /**
     * Pre-order
     * 前中后的递归都差不多
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {

        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    /**
     * Get Height of
     * Time O(n)
     * Space O(n)
     */
    public int findHeight(TreeNode root) {
        // Write your solution here
        if (root == null) return 0;
        return Math.max(findHeight(root.left) + 1, findHeight(root.right) + 1);
    }
    /**
     * How to determine whether a binary tree is a balanced binary tree?
     * Time O()
     * Space O()
     */
    public boolean isBalanced(TreeNode root) {
        // Write your solution here
        if (root == null) return true;
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(helper(root.left), helper(root.right));
    }

    /**
     * How to judge whether a binary tree is symmetric?
     * 没有说这个树是balanced
     * Time O(n)
     * Space O(n) -> O(height)
     * Space O(logn) if the tree is balanced
     */
    public boolean isSymmetric(TreeNode root) {
        // Write your solution here
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.val != two.val){
            return false;
        }
        return helper(one.left, two.right) && helper(one.right, two.left);
    }
    /**
     * Tweaked Identical Binary Trees
     */
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        // Write your solution here
        if (one == null && two == null) return true;
        return helper(one, two);
    }

    public boolean helper1(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.val != two.val) {
            return false;
        }
        return (helper1(one.left, two.left) && helper1(one.right, two.right)) ||
                (helper1(one.left, two.right) && helper1(one.right, two.left));
    }

    /**
     * How to determine a binary tree is a BST?
     */

}
