package leetCode.binarySearch_05;

public class E_167_TwoSumII {

    /**
     * Time O(n) 看似是二分思想，但是没有除以2的操作，所以不是logn
     * Space O(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return new int[]{-1, -1};
        int start = 0;
        int end = numbers.length - 1;

        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if (target == sum) {
                return new int[]{start + 1, end + 1};
            } else if (sum > target){
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }
}
