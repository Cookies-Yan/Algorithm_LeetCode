package leetCode.binarySearch_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H_315_CountOfSmallerNumbersAfterSelf {
    /**
     * [5, 2, 6, 1]
     * int[] Arrays.asList() 因为用这个函数，需要里面是对象
     * 所以创建数组用Integer[] res = new Integer[nums.length]
     *
     * 通过在list里面排序,如果插入index=2的位置，贼说明此数字前面有两个小于它的数
     * 0 1 1 2
     * Time O(n^2)
     * Space O(n)
     *
     * [5, 2, 6, 1]
     *
     */
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length]; //为了能用Arrays.asList(res)
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(list, nums[i]);
            res[i] = index;
            list.add(index, nums[i]);
        }
        return Arrays.asList(res);
    }

    private int findIndex(List<Integer> list, int target) {
        if (list.size() == 0) return 0;
        int start = 0;
        int end = list.size() - 1;
        if (list.get(end) < target) return end + 1;
        if (list.get(start) >= target) return 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (list.get(start) >= target) return start;
        return end;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 6, 1};
        H_315_CountOfSmallerNumbersAfterSelf cool = new H_315_CountOfSmallerNumbersAfterSelf();
        System.out.println(cool.countSmaller(a));
    }
}
