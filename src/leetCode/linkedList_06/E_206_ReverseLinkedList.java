package leetCode.linkedList_06;

public class E_206_ReverseLinkedList {

    private class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {val = x;}
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

}
