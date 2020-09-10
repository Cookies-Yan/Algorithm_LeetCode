package leetCode.array_04;

import java.util.Arrays;

/**
 * 时间复杂度至少是nlogn
 */

public class M_253_MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int end = 0;
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[end]) {
                res++;
            } else {
                end++;
            }
        }
        return res;
    }
}
