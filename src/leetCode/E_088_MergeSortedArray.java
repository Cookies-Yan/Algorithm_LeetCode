package leetCode;

public class E_088_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = n - 1;
        int j = m - 1;
        int k = m + n -1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
