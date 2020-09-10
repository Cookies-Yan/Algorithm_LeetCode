package leetCode.linkedList_06;

public class M_086_PartitionList {

    /**
     * Time O(n)
     * Space O(n) 每次都要用你temp开辟一个空间
     *
     * Input: head = 1->4->3->2->5->2, x = 3
     * Output: 1->2->2->4->3->5
     *
     * 运行过程
     * x = 3
     *
     * smallHead -> 1 -> 2 -> 2 ->
     *                       small
     * bigHead -> 4 -> 3 -> 5 ->
     *                      big
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode big = bigHead;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            if (head.val < x) {
                small.next = temp;
                small = small.next;
            } else {
                big.next = temp;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigHead.next;
        return smallHead.next;
    }


     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
