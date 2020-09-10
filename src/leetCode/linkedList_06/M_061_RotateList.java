package leetCode.linkedList_06;

public class M_061_RotateList {

    /**
     * 与解法二一样，稍微简便一些
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode index = head;
        int len = 1;
        while (index.next != null) {
            index = index.next;
            len++;
        }
        index.next = head;// 形成环
        for (int i = 1; i < len - k % len; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }

    /**
     * 自己写的解法
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int size = 0;
        ListNode dummy = new ListNode(0);
        ListNode head1 = new ListNode(0);
        dummy.next = head;
        head1.next = head;
        while (head1.next != null) {
            size++;
            head1 = head1.next;
        }
        int step = size - k % size - 1;
        while (step != 0) {
            head = head.next;
            step--;
        }
        head1.next = dummy.next;
        dummy.next = head.next;
        head.next = null;
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
