package leetCode.array_04;

import java.util.Arrays;

public class M_075_SortColors {
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (index <= end) {
            if (nums[index] == 0) {
                swap(nums, start++, index++);
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, end--);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
