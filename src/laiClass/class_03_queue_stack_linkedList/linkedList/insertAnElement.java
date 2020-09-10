package laiClass.class_03_queue_stack_linkedList.linkedList;

public class insertAnElement {

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

    public void insertAnElement(ListNode head, int target) {
        if (head == null) {
            head.val = target;
        }
        if (head.val > target) {
            ListNode newNode = new ListNode(target);
            newNode.next = head;
            head = newNode;
            return;
        }
        while (head.next != null) {
            if (head.val <= target && head.next.val > target) {
                ListNode newNode = new ListNode(target);
                newNode.next = head.next;
                head.next = newNode;
                return;
            } else {
                head = head.next;
            }
        }
        ListNode newNode = new ListNode(target);
        head.next = newNode;
        newNode.next = null;
    }
}
