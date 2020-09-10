package leetCode.tree_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Time O(n)
//Space O(h)
public class E_589_NAryTreePreoderTraversal {

    /*递归*/
    public List<Integer> preorder(Node root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;

    }

    public void helper(List<Integer> res, Node root) {
        if (root == null) return;
        res.add(root.val);
        for (Node child : root.children) {
            helper(res, child);
        }
    }

    /*迭代*/
    public List<Integer> preorder1(Node root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            res.add(cur.val);

            for (int i = cur.children.size() - 1; i >= 0; i--) {
                //get是List<Node> _children 的函数，因为得到的是children List
                stack.push(cur.children.get(i));
            }

        }

        return res;

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
