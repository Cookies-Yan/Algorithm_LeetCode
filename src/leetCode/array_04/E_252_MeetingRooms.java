package leetCode.array_04;

import java.util.Arrays;

public class E_252_MeetingRooms {

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
