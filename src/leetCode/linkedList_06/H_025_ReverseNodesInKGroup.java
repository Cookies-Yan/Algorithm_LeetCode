package leetCode.linkedList_06;

/**
 * Time O(n)
 * Space O(n)
 * 不是很重要
 * 1->2->3->4->5 k = 2
 * count = 0 cur = 1
 * count = 2 cur = 3
 *      3->4->5
 *          count = 2 cur 5
 *              5->null
 *  head   temp   cur
 *   1  ->  2  ->  4
 *   cur = head 直接将cur的地址指向head
 *
 *  head   temp
 *   1  ->  2  ->  4
 *  cur
 *    head = temp
 *
 *         temp
 *   1  ->  2  ->  4
 *  cur    head
 *
 */
public class H_025_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
