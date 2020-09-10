package leetCode;

/**
 * time / space: O(n * 2^n)
 */
public class M_092_ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        for (int i = 1; i < m; i++) {
            cur = cur.next;
            pre = pre.next;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;

        }

        return dummy.next;
    }


    private class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
