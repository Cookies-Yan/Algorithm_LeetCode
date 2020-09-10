package leetCode.linkedList_06;

/**
 * Time O(n)
 * Space O(1)
 */
public class M_328_OddEvenLinkedList {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}
