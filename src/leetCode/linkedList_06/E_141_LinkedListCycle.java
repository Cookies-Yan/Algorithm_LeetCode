package leetCode.linkedList_06;

public class E_141_LinkedListCycle {

    private class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {val = x;}
    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        /**
         * 一般以走的块的为边界条件
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

}
