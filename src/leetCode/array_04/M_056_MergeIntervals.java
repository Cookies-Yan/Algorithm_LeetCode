package leetCode.array_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Time: O(nlogn)
 * Space: O(n)
 */
public class M_056_MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] interval : intervals) {
            if (interval[0] <= end) {
                end = Math.max(interval[1], end);
            } else {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        /**
         * 最后一个判断完以后也要写进去
         */
        res.add(new int[] {start, end});
        return res.toArray(new int[][]{});
    }

    /**
     * 不同的输入方式
     */
//    public List<Integer> merge1(List<Integer> intervals) {
//        if (intervals == null || intervals.size() <= 1) return intervals;
//        Collections.sort(intervals, (a, b) - a.start - b.start);
//        int start = intervals.get(0).start;
//        int end = intervals.get(0).end;
//        List<Integer> res = new ArrayList<>();
//        for (Interval interval : intervals) {
//            if(interval.start <= end) {
//                end = Math.max(end, interval.end);
//            } else {
//                res.add(new Interval((start, end));
//                start = interval.start;
//                end = interval.end;
//            }
//        }
//        res.add(new Interval(start, end));
//        return res;
//    }

}
