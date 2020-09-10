package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class H_145_BinaryTreePostorderTraversal {
    /*递归*/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }

    /*迭代*/
    public List<Integer> postorderTraversal1(TreeNode root) {

        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return res;
    }
}
