package leetCode.linkedList_06;

public class E_203_RemoveLinkedListElements {
    /**
     * Time O(n)
     * Space O(1)
     * 方法1,用dummy节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }

    /**
     * 方法2，不用dummy
     * Time O(n)
     * Space O(1)
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) return head;
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head.val == val ? head.next : head; //但是对头节点的删除会拿出来单独处理
    }

    /**
     * 递归的形式
     * Time O(n)
     * Space O(n)
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
