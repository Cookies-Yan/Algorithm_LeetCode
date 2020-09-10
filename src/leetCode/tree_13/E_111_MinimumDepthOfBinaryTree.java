package leetCode.tree_13;
import algorithm.tree.binarysSearchTree.TreeNode;

//Time O(n)
//Space O(h)
public class E_111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
