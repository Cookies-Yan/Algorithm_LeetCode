package leetCode.tree_13;

import java.util.*;

/**
 * level order;
 * Time O(n)
 * Space O(n)
 */
public class M_199_BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    res.add(cur.val);
                }
                /**
                 * 如果先写左边的话，那就要i == size - 1；我们要右边，所以是一层的最后一个节点
                 */
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }

        }
        return res;
    }

    /*DFS 递归*/
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(root.val);
        }
        helper(res, root.right, level + 1);
        helper(res, root.left, level + 1);
    }

    /**
     * level order变形，跑的很慢
     * @param root
     * @return
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    res.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

        }
        return res;
    }

    class TreeNode {

        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
