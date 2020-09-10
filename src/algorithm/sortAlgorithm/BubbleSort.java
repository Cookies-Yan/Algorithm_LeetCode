package algorithm.sortAlgorithm;

import java.util.Arrays;

/**
 * 时间复杂度：最好O(n)，最坏O(n^2) 平均O(n^2)
 * 空间复杂度：O(1)
 */
public class BubbleSort {

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println("当前第: " + (i + 1) + "轮状态: " + Arrays.toString(nums));
            for (int j = nums.length - 1; j > i; j--) {
                if(nums[j] < nums[j - 1]) {
                    swap(nums, j,j - 1);
                }
                System.out.println("第" + (i + 1) + "轮步骤: " + Arrays.toString(nums));
            }
        }
    }
    //优化冒泡排序额，让最好O为O(n)
    private static void bubbleSortBest(int[] nums) {

        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            flag = false;
            System.out.println("当前第: " + (i + 1) + "轮状态: " + Arrays.toString(nums));
            for (int j = nums.length - 1; j > i; j--) {
                if(nums[j] < nums[j - 1]) {
                    swap(nums, j,j - 1);
                    flag = true;
                }
                System.out.println("第" + (i + 1) + "轮步骤: " + Arrays.toString(nums));
            }
            if(!flag) {
                break;
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
        bubbleSort(nums);

    }
}
