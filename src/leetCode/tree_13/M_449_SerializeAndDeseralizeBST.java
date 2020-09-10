package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Time O(n)
 * Space O(n)
 *       5
 *     /  \
 *    4   6
 *   /     \
 *  1       8
 *  5 4 1 6 8
 *  queue: 6 8
 *  root: 5
 *  smallerq: 4 1
 *
 */
public class M_449_SerializeAndDeseralizeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.append(cur.val + " ");
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] str = data.split(" ");
        Queue<Integer> queue = new LinkedList<>();
        for (String s : str) {
            queue.offer(Integer.parseInt(s));
        }
        return getNode(queue);
    }

    public TreeNode getNode(Queue<Integer> queue) {
        if (queue.isEmpty()) return null;
        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> smallerQ = new LinkedList<>();
        while (!queue.isEmpty() && queue.peek() < root.val) {
            smallerQ.offer(queue.poll());
        }
        root.left = getNode(smallerQ);
        root.right = getNode(queue);
        return root;
    }
}
