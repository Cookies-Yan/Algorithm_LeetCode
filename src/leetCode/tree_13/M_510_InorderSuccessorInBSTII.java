package leetCode.tree_13;

public class M_510_InorderSuccessorInBSTII {
    public Node inorderSuccessor(Node node) {
        //右边的部分
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        //上面的部分
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
}
