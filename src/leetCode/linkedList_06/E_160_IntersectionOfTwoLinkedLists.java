package leetCode.linkedList_06;

public class E_160_IntersectionOfTwoLinkedLists {
    /**
     * 第一种方法
     * 先把两个长度不相同的链表的长度统一
     * Time O(n)
     * Space O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        while (lenA != lenB) {
            if (lenA > lenB) {
                headA = headA.next;
                lenA--;
            } else {
                headB = headB.next;
                lenB--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    private int getLen(ListNode head) {
        int len = 1;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    /**
     *  方法二
     *  把两个链表的长度相加，凑成长度一样的
     *  Time O(m + n)
     *  Space O(1)
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }


     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
  }
}
