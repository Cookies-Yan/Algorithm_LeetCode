package leetCode.tree_13;

import algorithm.tree.binarysSearchTree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class H_431_EncodeNAryTreeToBinaryTree {

    //Time O(n)
    //Space O(n)

    /**
     * 将root的所有孩子全部加入第一个孩子的右节点中
     *          1               1
     *       /  |  \          /
     *      3   2   4  ==>   3
     *    /  \             /  \
     *   5    6           5    2
     *                     \    \
     *                      6    4
     * @param root
     * @return
     */
    public TreeNode encode(Node root) {
        if (root == null) return null;
        TreeNode res = new TreeNode(root.val);
        if (root.children.size() > 0) {
            res.left = encode(root.children.get(0));
        }
        TreeNode cur = res.left;
        for (int i = 1; i < root.children.size(); i++) {
            cur.right = encode(root.children.get(i));
            cur = cur.right;
        }
        return res;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;
        Node res = new Node(root.val, new LinkedList<>());
        TreeNode cur = root.left;
        while (cur != null) {
            res.children.add(decode(cur));
            cur = cur.right;
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;
        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
