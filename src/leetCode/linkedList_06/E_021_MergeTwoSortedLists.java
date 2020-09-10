package leetCode.linkedList_06;

/**
 * Created by cookies
 * Time: O(n)
 * Space: O(1)
 */

public class E_021_MergeTwoSortedLists {
//By Iteration
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if (l1 != null) {
                cur.next = l1;
            } else {
                cur.next = l2;
            }
            return dummy.next;
    }
//  By recursion
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

    }

    private static class ListNode {

        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
