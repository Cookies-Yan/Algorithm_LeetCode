package algorithm.sortAlgorithm;

import java.util.Arrays;

/**
 * 时间复杂度：最好O(n)，最坏O(n^2) 平均O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 */
public class InsertSort {
    public static void inserSort (int[] nums) {
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println("当前第" + (i + 1) + "轮状态: " + Arrays.toString(nums));
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
                System.out.println("第" + (i + 1) + "轮步骤: " + Arrays.toString(nums));
            }
        }
    }

    /**
     * 时间复杂度：最好O(nlogn)，最坏O(n^2) 平均O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */
    public static void insertBinatrySort(int[] nums) {
        int temp;
        int low;
        int high;
        int mid;
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.println("当前第" + (i + 1) + "轮状态: " + Arrays.toString(nums));

            temp = nums[i + 1];
            low = 0;
            high = i;
            while (low <= high) {
                mid = (low + high) / 2;
                if (nums[mid] < temp) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            //整个数组后移
            for (int j = i; j > high; j--) {
                nums[j + 1] = nums[j];
            }
            nums[high + 1] = temp;
            System.out.println("第" + (i + 1) + "轮步骤: " + Arrays.toString(nums));

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 9, 4, 7, 6, 1, 3, 8};
        insertBinatrySort(nums);

    }
}
