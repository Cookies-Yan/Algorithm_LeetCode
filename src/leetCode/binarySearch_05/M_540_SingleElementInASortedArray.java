package leetCode.binarySearch_05;

public class M_540_SingleElementInASortedArray {

    /**
     *  正常是2n = 2n + 1
     *  但是有一个single, 这个single前面不变，但是后面就成了 2n + 1 = 2n+ 2
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        // if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length / 2;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[2 * mid] != nums[2 * mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[2 * left];
    }

    /**
     * M2
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean halvesAreEven = (hi - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (halvesAreEven) {
                    lo = mid + 2;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }
}
