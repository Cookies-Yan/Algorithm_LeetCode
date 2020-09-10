package leetCode.tree_13;
import algorithm.tree.binarysSearchTree.TreeNode;

public class M_250_CountUnivalueSubtrees {
    //Time O(n)
    //Space O(h)
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return res;
    }

    public boolean helper(TreeNode root) {
        if (root == null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            res++;
            return true;
        }
        return false;
    }
}
