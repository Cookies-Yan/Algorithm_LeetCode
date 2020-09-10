package leetCode.linkedList_06;

public class E_237_DeleteNodeInALinkedList {
    private class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {val = x;}
    }
    /**
     * 在工作中需要释放节点的空间
     * 给的是node, 可以直接操作
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
