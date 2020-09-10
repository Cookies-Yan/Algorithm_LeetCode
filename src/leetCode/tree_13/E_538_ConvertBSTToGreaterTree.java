package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

import java.util.Stack;

//Time O(n)
//Space O(h)

/**
 * BST 中序遍历，是一个从大到小的顺序
 */
public class E_538_ConvertBSTToGreaterTree {

    /*递归*/
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    /*迭代*/
    int sum1 = 0;
    public TreeNode convertBST1(TreeNode root) {
        if (root == null)  return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum1 += cur.val;
            cur.val = sum1;
            cur = cur.left;
        }
        return root;

    }
}
