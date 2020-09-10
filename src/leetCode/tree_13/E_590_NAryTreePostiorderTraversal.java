package leetCode.tree_13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Time O(n）
//Space O(h)
public class E_590_NAryTreePostiorderTraversal {
    /*递归*/
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, Node root) {
        if (root == null) return;
        for (Node child : root.children) {
            helper(res, child);
        }
        res.add(root.val);
    }

    /*递归*/
    public List<Integer> postorder1(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            res.addFirst(cur.val);
            for (Node child : cur.children){
                stack.push(child);
            }
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
