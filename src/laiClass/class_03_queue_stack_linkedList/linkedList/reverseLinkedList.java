package laiClass.class_03_queue_stack_linkedList.linkedList;

public class reverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            this.val = val;
        }
        ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * No.1 interview question on linkedList: how to reverse linkedList
     * @param head
     * @return
     */
    public ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        while (head != null) {
            ListNode nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        return prev;
    }

    /**
     * No.1 interview question on linkedList: how to reverse linkedList
     * Recursion
     * @param head
     * @return
     */
    public ListNode reverseListNode1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseListNode1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {

    }
}
