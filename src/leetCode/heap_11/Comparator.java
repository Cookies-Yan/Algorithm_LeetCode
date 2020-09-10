package leetCode.heap_11;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Comparator {

    public static void compare1() {
        int[] nums = new int[]{1,2,3,4};
        /**
         * O(n)
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        /**
         * log(n) 高度是logn
         */
        for (int num : nums) {
            //排出来的是最小堆，升序排列的。
            priorityQueue.offer(num);
        }
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    public static void compare2() {
        int[] nums = new int[]{1,2,3,4};
        //用降序排列
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new java.util.Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

    }

    public static void compare3() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new java.util.Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.a - o2.a;
            }
        });

        String[] strings = new String[] {"12", "23"};
        Arrays.sort(strings, new java.util.Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o1;
                return s1.compareTo(s2) ;
            }
        });

    }

    public static void compare4() {
        int[] nums = new int[]{1,2,3,4};
        /**
         * (a,b)就是(o1,o2)
         * 5就是一个固定容量，但是超过了也没有关系，java有自动扩容的机制
         */
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(5,(a, b) ->(a.a - b.a));
//        priorityQueue<int[]> priorityQueue1 = new PriorityQueue<>((a, b) -> (a[0] +a[1] - b[0]) - b[1]);
    }

    class Node {
        int a;
        int b;
    }

    public static void main(String[] args) {
//        compare1();
        compare2();
    }

}
