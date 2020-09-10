package leetCode.tree_13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time: O(n)
 * Space: O(n)最差的时候，链表形式，高度等于长度
 */
//先序遍历是最常用的一种树的遍历方式
public class M_116_PopulatingNextRightPointersInEachNode {

    /**
     *      1
     *     / \
     *    2   3
     *   / \ / \
     *  4  5 6  7
     *
     *  After calling function
     *       1 ->NULL
     *     /  \
     *    2 -> 3->NULL
     *   / \  / \
     *  4->5->6->7->NULL
     *
     * @param root
     * @return
     */
    //PreOrder
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    //PreOrder
    /**
     * Time: O(n)
     * Space: O(1)
     */
    public Node connect2(Node root) {
        Node start = root;
        while (start != null) {
            Node cur = start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
        return root;
    }

    /**
     * Level order
     * @param root
     * @return
     */
    public Node connect3(Node root) {
        if(root == null){
            return root;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(queue.size()>0){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                Node node = queue.poll();
                if(i < size - 1){
                    node.next = queue.peek();
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
    private class Node {

        int val;
        Node left;
        Node right;
        Node next;

        public Node(int x) {
            this.val = x;
        }
    }

}
