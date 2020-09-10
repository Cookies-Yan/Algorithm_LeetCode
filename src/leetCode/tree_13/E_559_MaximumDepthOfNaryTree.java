package leetCode.tree_13;

import java.util.List;

public class E_559_MaximumDepthOfNaryTree {

    //Time O(n)
    //Space O(h)
    int res1 = 0;

    public int maxDepth(Node root) {
        if (root == null) return 0;
        helper1(root, 1);
        return res1;
    }

    public void helper1(Node node, int depth) {
        if (node == null) return;
        res1 = Math.max(res1, depth);

        for (Node child : node.children) {
            helper(child, depth + 1);
        }
    }


    /*513 DFS 启发*/
    int res = 0;
    int height = 0;

    public int maxDepth1(Node root) {
        if (root == null) return 0;
        helper(root, 1);
        return height;
    }

    public void helper(Node root, int depth) {

        if (root == null) return;

        if (height < depth) {
            res = root.val;
            height = depth;
        }

        for (Node child : root.children) {
            helper(child, depth + 1);

        }
    }

    /**
     * Class
     */
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
    };


}
