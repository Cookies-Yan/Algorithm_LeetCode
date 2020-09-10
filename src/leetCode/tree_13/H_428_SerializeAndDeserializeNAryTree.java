package leetCode.tree_13;

import java.util.*;

// Time O(n)
// Space O(n)
public class H_428_SerializeAndDeserializeNAryTree {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> list = new LinkedList<>();
        serializeHelper(root, list);
        return String.join(",", list);
    }

    private void serializeHelper(Node root, List<String> list) {
        if (root == null) return ;
        list.add(String.valueOf(root.val));
        list.add(String.valueOf(root.children.size()));
        for (Node child : root.children) {
            serializeHelper(child, list);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] s = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(s));
        return deserializeHelper(queue);
    }

    private Node deserializeHelper(Queue<String> queue) {
        Node root = new Node();
        root.val = Integer.parseInt(queue.poll());
        int size = Integer.parseInt(queue.poll());
        root.children = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            root.children.add(deserializeHelper(queue));
        }
        return root;

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
