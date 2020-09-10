package algorithm.heap.impl;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        MaxHeapImpl<Integer> maxHeap = new MaxHeapImpl<>();
        Integer[] nums = new Integer[]{2,23,30,8,32,41,1,15};
        /**
         * Time:O(nlogn)
         */
        for(Integer num : nums) {
            maxHeap.offer(num);
        }
//        maxHeap.print();
//        PriorityQueue<Student> priorityQue = new PriorityQueue<>((a,b) -> (a.score - b.score));
        /**
         * PriorityQueue默认给的是最小堆
         */
        PriorityQueue<Integer> priorityQue = new PriorityQueue<>();
        for(Integer num : nums) {
            priorityQue.offer(num);
        }
        System.out.println(priorityQue.poll());
        System.out.println(priorityQue.poll());
        System.out.println(priorityQue.poll());

    }

    class student {
        int score;
    }
}
