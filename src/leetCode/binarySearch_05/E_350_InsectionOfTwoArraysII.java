package leetCode.binarySearch_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class E_350_InsectionOfTwoArraysII {

    /**
     * Method1
     * 跟LC349 不同的是， 他要把重复的输出出来。 所以不能用HashSet
     * Time: O(n)
     * Space: O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                if (map.get(nums2[i]) > 0) {
                    ret.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }
        }
        int[] res = new int[ret.size()];
        int k = 0;
        for (Integer num : ret) {
            res[k++] = num;
        }
        return res;
    }
    /**
     * Method2
     * 上一个题是用了set.这道题用了list,
     * Time O(nlogn);
     * Spave O(n)
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ret.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[ret.size()];
        int k = 0;
        for (Integer num : ret) {
            res[k++] = num;
        }
        return res;
    }

}
