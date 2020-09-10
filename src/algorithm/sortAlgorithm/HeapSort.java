package algorithm.sortAlgorithm;

import java.util.Arrays;

/**
 * 1.	建堆（时间O（n））
 * 2.	调整堆（时间（O（logn）））
 * 3	时间复杂度：O（nlongn）最好/平均/最坏
 * 4.   空间复杂度:O（1）
 * 5.   不稳定
 */
public class HeapSort {
    /**
     * 所有的叶子节点正好是所有节点数n除以2：
     * @param nums
     */
    public static void heapSort(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            heapAdjust(nums, i, nums.length);
        }
        System.out.println(Arrays.toString(nums));
        for(int i = nums.length - 1; i > 0; i--) {
            swap(nums,0, i);
            heapAdjust(nums, 0, i);
        }
    }

    public static void heapAdjust(int[] nums, int start, int length) {
        int child = 2 * start + 1;
        while (child < length) {
            if (child + 1 < length && nums[child] < nums[child + 1]) {
                child++;
            }
            if(nums[start] < nums[child]) {
                swap(nums, start, child);
            } else {
                break;
            }
            start = child;
        }
    }

    public static void swap(int[] nums, int i , int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,23,30,8,32,41,1,15};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
