package laiClass.class_03_queue_stack_linkedList.linkedList;

public class reoderList {
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

    public void reorderList1(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode res = findMid(head);
        ListNode l2 = res.next;
        res.next = null;
        l2 = reverseList(l2);
        merge(head, l2);
    }

    public ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void merge(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null) {
            ListNode next1 = l1.next, next2 = l2.next;
            l1.next = l2;
            l1 = next1;
            l2.next = l1;
            l2 = next2;
        }
    }

}
