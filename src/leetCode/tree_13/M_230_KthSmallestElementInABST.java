package leetCode.tree_13;

import java.util.Stack;

public class M_230_KthSmallestElementInABST {

    /*迭代*/
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (++count == k) {
                return cur.val;
            }
            cur = cur.right;
        }
        return root.val;
    }

    //Time O(n)
    //Space O(n)
    /*递归*/
    int count;
    int res;

    public int kthSmallest1(TreeNode root, int k) {
        count = k;
        res = 0;
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        // if (count == 0) {
        //     res = root.val;
        // }
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
        }
        helper(root.right);
    }

    class TreeNode {

        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.left = null;
            this.right = null;
            this.val = val;
        }
    }

}
