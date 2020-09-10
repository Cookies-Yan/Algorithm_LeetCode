package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//Time O(n)
//Space O(n)
public class M_513_FindBottomLeftTreeValue {

    /*DFS*/
    int res = 0;
    int height = 0;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        helper(root, 1);
        return res;
    }

    public void helper(TreeNode root, int depth) {
        if (root == null) return;
        if (height < depth) {
            res = root.val;
            height = depth;
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }

    /*BFS*/
    public int findBottomLeftValue1(TreeNode root) {

        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode cur = queue.poll();
            res = cur.val;
            if (cur.right != null) queue.offer(cur.right);
            if (cur.left != null) queue.offer(cur.left);
        }

        return res;
    }

    /*Level order经典模仿*/
    public int findBottomLeftValue2(TreeNode root) {
        int res = 0;
        if (root == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                res = cur.val;
                System.out.println(res);
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }
        }
        return res;
    }
}
