package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;
public class M_285_InorderSuccessorInBST {
    //Time O(h)
    //Space O(1)
    /*迭代*/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }

    /*递归*/
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) {
            return inorderSuccessor1(root.right, p);
        } else {
            TreeNode res = inorderSuccessor1(root.left, p);
            return res != null ? res : root;
        }
    }

}
