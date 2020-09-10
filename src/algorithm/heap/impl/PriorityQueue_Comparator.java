package algorithm.heap.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueue_Comparator {
    /**
     * 默认PriorityQueue给的是最小堆
     * 我们如果需要其实现最大堆，需要重写compare函数
     */
    public static void compare1(){

        int[] nums = new int[]{1,2,3,4};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }

    /**
     * 通过改变comparator，用PriorityQueue写为最大堆
     */
    public static void compare2() {

        int[] nums = new int[]{1,2,3,4};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            /**
             * Comparator是一个接口
             * 返回int型，若返回负数则第一个元素小于第二个元素
             * 返回0第一个等于第二个，返回正数第一个大于第二个(o1>o2)
             * 需要升序排列 o1 < o2 (o1 - o2)
             * 需要降序排列 o2 < o1 (o2 - o1)
             * @param o1
             * @param o2
             * @return
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int num : nums) {
            priorityQueue.offer(num);
        }
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

    }

    public static void compare3() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.a - o2.a;
            }
        });
//不常用
        String[] strings = new String[]{"12" , "23"};
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o1;
                return s1.compareTo(s2);
            }
        });
    }

    /**
     * 比较简略的写法
     * 以下属于一种λ表达式的形式，(a,b)相当于与(o1,o2).
     * (a.a - b.a)是我们自己形成一种排序的方式,等同于o1.a - o2.a;
     * (a,b)前面的数字是默认的PriorityQueue的容量，但是超过了也可以放，因为JAVA有自动扩容机制
     * 如果比较内容很复杂，还要用compare的形式
     */
    public static void compare4() {
        int[] nums = new int[]{1,2,3,4,};
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a,b) -> (a.a - b.a));
        PriorityQueue<int[]> priorityQueue1 = new PriorityQueue<>((a,b) -> (a[0] + a[1] - b[0] - b[1]));
    }

    class Node {
        int a;
        int b;
    }

    public static void main(String[] args) {
        compare1();
//        compare2();
    }


}
