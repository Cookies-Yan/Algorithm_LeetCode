package leetCode.linkedList_06;

public class M_148_SortList {
    /**
     * 在linkedlist中使用mergesort
     * Time O(nlogn)
     * Space O(n)
     *
     * Input: -1->5->3->4->0
     *               s
     *                     f
     * Output: -1->0->3->4->5
     *
     *
     *
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = getMiddle(head);
        ListNode next = middle.next;
        middle.next = null;
        return merge(sortList(head), sortList(next));
    }

    private ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy; //重新set一个链表
        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a == null) cur.next = b; //最后必定还有一个没有比
        else cur.next = a;
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
