package laiClass.class_01_array;

import java.util.Arrays;
import java.util.Stack;

public class selectionSort {

    //升序 n是size

    /**
     * 1.
     * Time O(n^2)
     * Space O(1)
     * @param a
     * @param n
     */
    public void selectSort(int[] a, int n) {
        if (a == null || a.length <= 1) return;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
         }
    }

    /**
     * 2.
     * Given an array stored in Stack1,
     * how to sort the numbers by using additional three stacks(will be discussed later in stack class)
     */
    public void selectSort1(int[] a) {
        int min = Integer.MAX_VALUE;
        int size = a.length;
        int count = 0; //为了去除重复，因为重复的话会把两个都删除
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        Stack<Integer> stack3 = new Stack();
        for (int i = 0; i < a.length; i++) {
            stack1.push(a[i]);
        }

        while (!stack1.isEmpty()) {
            min = Math.min(min, stack1.peek());
            stack2.push(stack1.pop());
            if (stack2.size() == size) {
                while (!stack2.isEmpty()) {
                    if (stack2.peek() == min && count < 1) {
                        stack2.pop();
                        count++;
                    } else {
                        stack1.push(stack2.pop());
                    }
                }
                stack3.push(min);
                min = Integer.MAX_VALUE;
                count = 0;
                size--;
            }
        }
        for(int i = a.length - 1; i >= 0; i--) {
            a[i] = stack3.pop();
        }
    }

    /**
     * 3.
     * Follow up, what if only two additional stack can be used?
     */
    public void selectionsort2(int[] array) {
        if (array == null || array.length == 0) return;
        Stack<Integer> stack1 = new Stack<>(); // 未排序的
        Stack<Integer> stack2 = new Stack<>(); //排好序的
        int min = Integer.MAX_VALUE;
        int size = array.length;
        for (int i = 0; i < array.length; i++) {
            stack1.push(array[i]);
        }

        while (!stack1.isEmpty()) {
            if (min > stack1.peek()) {
                min = stack1.peek();
            }
            stack2.push(stack1.pop());
            if (stack2.size() == size) {
                 while (!stack2.isEmpty() && stack2.peek() >= min) {
                     if (stack2.peek() == min) {
                         stack2.pop();
                     } else {
                         stack1.push(stack2.pop());
                     }
                 }
                 stack2.push(min);
                 min = Integer.MAX_VALUE;
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = stack2.pop();
        }
    }

    /**
     * 4.
     * Follow up, what if only two additional stack can be used?
     * 如果有重复元素怎么办
     */
    public void selectionSort3(int[] array) {

        if (array == null || array.length == 0) return;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int size = array.length;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            stack1.push(array[i]);
        }

        while (!stack1.isEmpty()) {
            if (stack1.peek() <= min) {
                if (stack1.peek() == min) {
                    count++;
                } else {
                    min = stack1.peek();
                    count = 1;
                }
            }

            stack2.push(stack1.pop());
            if (stack2.size() == size) {
                while (!stack2.isEmpty() && stack2.peek() >= min) {
                    if (stack2.peek() == min) {
                        stack2.pop();
                    } else {
                        stack1.push(stack2.pop());
                    }
                }
                for (int i = 0; i < count; i++) {
                    stack2.push(min);
                }
                min = Integer.MAX_VALUE;
                count = 0;
            }
        }

        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = stack2.pop();
        }

    }


    public static void main(String[] args) {
        selectionSort c = new selectionSort();
        int[] a = {3, 1, 4, 4};
        c.selectSort(a, a.length);
//        c.selectSort1(a);
        System.out.println(Arrays.toString(a));
        int[] b = {4, 5, 1, 7, 9, 3, 0};
        c.selectionsort2(b);
        System.out.println(Arrays.toString(b));
        int[] d = { 3, 3, 1, 2, 2, 1, 1, 1, 0, 0, 9, 8, 8, 7};
        c.selectionSort3(d);
        System.out.println(Arrays.toString(d));
    }
}
