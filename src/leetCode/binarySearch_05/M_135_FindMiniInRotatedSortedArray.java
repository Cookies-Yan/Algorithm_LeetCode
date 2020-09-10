package leetCode.binarySearch_05;

public class M_135_FindMiniInRotatedSortedArray {

    /**
     * Time O(logn)
     * Space O(1)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return - 1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1; //等于mid也可
            } else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]) return nums[start];
        else return nums[end];
    }
}
