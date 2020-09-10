package leetCode.linkedList_06;

public class E_082_RemoveDuplicatesFromSortedListII {

    private class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {val = x;}
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.next.val == cur.next.val) {
                int sameNum = cur.next.val; //奇数个的情况下，要保存重复值
                while (cur.next != null && cur.next.val == sameNum) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}
