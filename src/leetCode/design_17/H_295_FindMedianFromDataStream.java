package leetCode.design_17;

import java.util.PriorityQueue;

/**
 * Time O(logn) 加入和poll() 复杂度都是log
 * Space O(n)
 */
public class H_295_FindMedianFromDataStream {

    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;
    /** initialize your data structure here. */
    public H_295_FindMedianFromDataStream() {
        this.large = new PriorityQueue<>(); //大的一侧,最小堆
        this.small = new PriorityQueue<>((a, b) -> (b - a)); //小的一侧最大堆
    }

    public void addNum(int num) {     //小的一侧，始终比大的一侧持相等或者多一个元素
        small.offer(num);
        /**
         * 保证两个堆元素数量的差值不超过1
         */
        large.offer(small.poll());
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }

    public double H_295_FindMedianFromDataStream() {
        return small.size() > large.size() ? small.peek() : (large.peek() + small.peek()) / 2.0;
    }

    /**
     * 下面这种方法不好取 ，很慢
     */
    /** initialize your data structure here. */
//    PriorityQueue<Integer> queue;
//    List<Integer> list;
//    public H_295_FindMedianFromDataStream() {
//        this.queue = new PriorityQueue<>();
//        this.list = new ArrayList<>();
//    }

//    public void addNum1(int num) {
//        // queue.add(num);
//        list.add(num);
//        Collections.sort(list);
//    }
//
//    public double findMedian() {
//        int count = list.size();
//        if (count % 2 == 0) {
//            return (list.get(count/2) + list.get(count/2 - 1)) / 2.0;
//        } else {
//            return list.get(count/2);
//        }
//
//    }
}
