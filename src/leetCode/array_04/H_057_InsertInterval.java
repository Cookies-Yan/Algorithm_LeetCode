package leetCode.array_04;

import java.util.ArrayList;
import java.util.List;

public class H_057_InsertInterval {

    /**
     * Time O(n)
     * Space O(n)
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) return intervals;
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while (i < intervals.length) {
            res.add(intervals[i++]);
        }
        return res.toArray(new int[res.size()][]);
    }

}
