package laiClass.class_03_queue_stack_linkedList.linkedList;

public class partitionList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode smallTail = dummy1;
        ListNode largeTail = dummy2;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;

            } else {
                largeTail.next = new ListNode(cur.val);
                largeTail = largeTail.next;
            }
            cur = cur.next;
        }
        smallTail.next = dummy2.next;
        largeTail.next = null;
        return dummy1.next;
    }
}
