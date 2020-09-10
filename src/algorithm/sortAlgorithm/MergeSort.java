package algorithm.sortAlgorithm;

import java.util.Arrays;

/**
 * 时间复杂度：最好O(nlogn)，最坏O(nlogn) 平均O(nlogn)
 * 空间复杂度：O(n)
 * 稳定性： 稳定
 */
public class MergeSort {
    public static int[] mergeSort(int[] nums, int low, int high) {

        int mid  = (low + high) / 2;
        if (low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge (nums, low, mid, high);
        }
        return nums;
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        //走temp数组
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] =nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (int x = 0; x < temp.length; x++) {
            nums[x + low] = temp[x];
        }
        System.out.println("当前排序结果： " + Arrays.toString(temp));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 9, 8, 6, 4, 2, 0};
        mergeSort(nums,0,nums.length - 1);

    }
}
