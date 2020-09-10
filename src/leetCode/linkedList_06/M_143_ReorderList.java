package leetCode.linkedList_06;

public class M_143_ReorderList {

    /**
     * Time O(n)
     * Space O(1)
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode l1 = head;
        while (fast != null && fast.next != null) { //找中点
            temp = slow; // 比slow 慢一步
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }

    private ListNode reverse(ListNode head) { //翻转
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    /**
     *    n1
     * 1  2
     * |
     * 4  3
     *    n2
     * @param l1
     * @param l2
     */
    private void merge(ListNode l1, ListNode l2) {
        while (l1 != l2) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            if (n1 == null) break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
