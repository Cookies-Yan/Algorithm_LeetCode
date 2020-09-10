package leetCode.binarySearch_05;

public class M_033_SearchInRotatedSortedArray {

    /**
     * 4 5 6 7 0 1 2
     *
     * 4 5 6 0 1 2 3
     *
     * 肯定有一般是递增的情况
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            /**
             * 判断到底是左边递增还是右边递增，判断start和mid
             * end和mid
             */
            if (nums[start] <= nums[mid]) { //左边递增
                if (target < nums[mid] && target >= nums[start]) { //在左边进行二分
                    end = mid - 1;
                } else {                                           //如果在右边的话
                    start = mid + 1;
                }
            }

            if (nums[mid] <= nums[end]) { //右边递增
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}
