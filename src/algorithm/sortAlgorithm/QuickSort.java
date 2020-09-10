package algorithm.sortAlgorithm;

import java.util.Arrays;

/**
 * Time(best):O(nlogn);
 *     (avg):O(nlogn);
 *     (worst):O(n^2);
 * Space:(nlogn ~ n);
 * 稳定性：不稳定
 */

public class QuickSort {
    public static void quickSort(int[] nums, int left, int right){
        if(left < right){
            int pivot = partitions(nums, left, right);
            quickSort(nums,left, pivot - 1);
            quickSort(nums,pivot + 1, right);
        }
    }
    public static int partitions(int[] nums, int left, int right){
        int pivotIndex = left;
        int pivot = nums[pivotIndex];
        int l = left + 1;
        int r = right;
        while(l <= r){
            if(nums[l] > pivot && nums[r] < pivot){
                swap(nums, l++, r--);
            }
            if(nums[l] <= pivot){
                l++;
            }
            if(nums[r] >= pivot){
                r--;
            }
        }
        swap(nums, pivotIndex, r);
        return r;
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void main(String[] args) {
        int[] cool = new int[]{2,4,2,5,4,654,534,65,2346,45};
        quickSort(cool, 0, cool.length - 1);
        System.out.println(Arrays.toString(cool));
    }

}
