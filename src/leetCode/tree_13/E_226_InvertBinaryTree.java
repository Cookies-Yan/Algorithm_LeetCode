package leetCode.tree_13;

import java.util.LinkedList;
import java.util.Queue;

//Time O(n)
//Space O(n)
public class E_226_InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     *  DFS
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right  = left;
        return root;
    }

    /**
     * BFS
     */
    public TreeNode invertTree1(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return root;
    }
}
