package leetCode.binarySearch_05;

public class H_154_FindMinimumInRotatedSortedArrayII {
    /**
     * Time O(logn) Worst(n)最坏还要走一遍
     * Space O(1)
     * 1 1 1 1 2 1
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[end]) {
                end--;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]) return nums[start];
        else return nums[end];
    }
}
