package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//Time O(n)
//Space O(n)
public class E_404_SumOfLeftLeaves {

    /**
     * 把res 写成全球变量
     */
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null )  {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            }
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return res;

    }

    /**
     * 不把res 写成全球变量
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        if (root.left != null )  {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves(root.left);
            }
        }
        res += sumOfLeftLeaves(root.right);
        return res;
    }

    /**
     * BFS 迭代
     * @param root
     * @return
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                if (cur.left.left == null && cur.left.right == null) {
                    res += cur.left.val;
                } else {
                    queue.offer(cur.left);
                }
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return res;
    }
}
