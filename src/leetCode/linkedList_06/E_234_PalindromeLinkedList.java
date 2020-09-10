package leetCode.linkedList_06;

public class E_234_PalindromeLinkedList {

    private class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {val = x;}
    }
    /**
     *1.找middle
     *2.进行reverse
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = findMiddle (head);
        middle.next = reverse(middle.next);
        ListNode p = head;
        ListNode q = middle.next;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }

        return true;

    }
    public ListNode findMiddle(ListNode head) {
        /**
         * 1 2 null
         * 中点是1，不是2
         * 所以不是slow 和 fast都等于head
         */
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
