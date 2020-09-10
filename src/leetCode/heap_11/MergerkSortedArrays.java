package leetCode.heap_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergerkSortedArrays {

    public static int[] mergerkSortedArrays(int[][] arrays) {

        List<Integer> ret = new ArrayList<>(); //所有的操作都在ArrayList里面，因为动态数组好操作
        if (arrays == null || arrays.length == 0) {
            return new int[]{};
        }

        /**
         * 将类放入PriorityQueue中
         */
        PriorityQueue<ArrayContainer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length != 0) { //边界条件，这个取出来的数组不能为空
                ArrayContainer ac = new ArrayContainer(arrays[i], 0);
                priorityQueue.offer(ac);
            }
        }

        /**
         * 处理PriorityQueue
         */
        while (!priorityQueue.isEmpty()) {
            ArrayContainer ac = priorityQueue.poll();
            ret.add(ac.array[ac.index++]);
            if (ac.index < ac.array.length) { //把数组拿出来，加入元素和index++以后，还要重新将数组放回
                priorityQueue.offer(ac);
            }
        }

        /**
         * 将最终的结果重进写入array,进行return
         */
        int[] res = new int[ret.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ret.get(i);
        }
        return res;
    }

    /**
     * 创建一个含有数组和index属性的类
     */
    private static class ArrayContainer implements Comparable<ArrayContainer> {
        int[] array;
        int index;
        public ArrayContainer(int[] array, int index) {
            this.array = array;
            this.index = index;
        }

        /**
         * 重写比较函数
         * @param o
         * @return
         */
        @Override
        public int compareTo(ArrayContainer o) {
            return this.array[index] - o.array[o.index];
        }
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] arr3 = {0, 9, 10, 11};

        System.out.println(Arrays.toString(mergerkSortedArrays(new int[][] {arr1, arr2, arr3})));
    }
}
