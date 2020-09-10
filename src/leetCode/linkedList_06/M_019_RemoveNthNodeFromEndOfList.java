package leetCode.linkedList_06;

public class M_019_RemoveNthNodeFromEndOfList {


    /**
     * Time : O(n)
     * Space : O(1)
     */
    private class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {val = x;}
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;

    }
}
