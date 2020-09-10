package leetCode.heap_11;

import java.util.PriorityQueue;

public class H_023_MergeKSortedLists {

    /*Time O(nlogk) K是linkedlist个数 Space O(n)*/

    /**
     * l1 : 2 3 4 5
     * l2 : 8 10 11 ->m
     *                   ->return
     * l3 : 0 7 9
     * l4 : 1 99 100 ->n
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    public ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return lists[lo];
        int mid = (hi - lo) / 2 + lo;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return merge(l1, l2);
    }
    /* n */
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }

    /*Time O(nlogk)  Space O(n)*/
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        //PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
        //使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器对元素进行排序。
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val); //按链表的头进行排序
        /**
         * 1,4,5
         * 3,3,4
         * 2,3,5
         *
         * 变成
         * 1,4,5
         * 2,3,5
         * 3,3,4
         */
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
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
