package leetCode.tree_13;
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
 */
public class M_117_PopulatingNextRightPointersInEachNodeII {
    //Time O(n)
    // Space O(1)
    public Node connect(Node root) {
        Node cur = root;
        Node head = null;
        Node pre = null;
        while (cur != null) { //控制一个树
            while (cur != null) { //控制一个层
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    pre = cur.left;
                }
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            pre = null;
        }
        return root;
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
