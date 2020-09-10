package leetCode.binarySearch_05;

import java.util.Arrays;

public class H_354_RussianDollEnvelopes {
    /**
     * Time O(nlogn)
     * Space O(n)
     * [2, 3] -> [5, 4] -> [6, 7] -> [6, 4]
     * [2, 6] -> [5, 5] -> [6, 7] -> [6, 4] -> [8, 8]
     * 按x从小到大排序，
     * y按照找最长的递增序列来找
     * 3 4 7 4 -> 3 4 7
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int[] envelope : envelopes) {
            int i = binarySearch(dp, 0, res, envelope[1]);
            dp[i] = envelope[1];
            if (i == res) {
                res++;
            }
        }
        return res;
    }

    public int binarySearch(int[] dp, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (dp[mid] == target) {
                return mid;
            } else if (dp[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (dp[start] >= target) return start;
        return end;
    }

    public static void main(String[] args) {
//        [2, 6] -> [5, 5] -> [6, 7] -> [6, 4] -> [8, 8]
        int[][] cool = {{2, 6}, {5, 5}, {6, 7}, {6, 3}, {8, 8}};
        H_354_RussianDollEnvelopes envelope = new H_354_RussianDollEnvelopes();
        System.out.println(envelope.maxEnvelopes(cool));
    }
}
