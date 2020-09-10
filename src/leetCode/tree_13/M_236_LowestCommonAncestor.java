package leetCode.tree_13;
import algorithm.tree.binarysSearchTree.TreeNode;

//Time O(n)
//Space O(h)
public class M_236_LowestCommonAncestor {
    /*后序遍历*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}
