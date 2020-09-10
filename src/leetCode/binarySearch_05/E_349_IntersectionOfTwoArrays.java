package leetCode.binarySearch_05;

import java.util.Arrays;
import java.util.HashSet;

public class E_349_IntersectionOfTwoArrays {

    /**
     * Method 1 (binarySearch)
     * Time O(nlogn) 排序nlogn
     * Space O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if(binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int k = 0;
        int[] res = new int[set.size()];
        for(Integer num : set) {
            res[k++] = num;
        }
        return res;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid;
            } else if(nums[mid] < target) {
                start = mid;
            } else {
                return true;
            }
        }
        if (nums[start] == target || nums[end] == target) return true;
        return false;
    }


    /**
     * Method 2 (Arrays.sort)
     * Time O(nlogn)
     * Space O(n)
     *
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        // 这个遍历两个数组是M + N的复杂度
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]){
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int k = 0;
        int[] res = new int[set.size()];
        for (Integer e : set) {
            res[k++] = e;
        }
        return res;
    }

    /**
     * Method 3
     * Time O(n)
     * space O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ret = new HashSet<>();
        for (Integer num : nums1) {
            set.add(num);
        }
        for (Integer num : nums2) {
            if (set.contains(num)) {
                ret.add(num);
            }
        }
        int k = 0;
        int[] res = new int[ret.size()];
        for (Integer num : ret) {
            res[k++] = num;
        }
        return res;
    }
}
