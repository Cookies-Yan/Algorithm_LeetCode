package leetCode.binarySearch_05;

/**
 *
 * 4 5 6 7 0 1 2
 *
 * 4 5 6 0 1 2 3
 *
 * 如果是这种情况：
 * 1 1 1 3 1
 * 两种情况就不能判断了
 */
public class M_081_SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if (nums[start] <= nums[mid]) { //左边递增
                if (target < nums[mid] && target >= nums[start]) { //在左边进行二分
                    end = mid - 1;
                } else {                                           //如果在右边的话
                    start = mid + 1;
                }
            } else { //右边递增
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return false;
    }
}
