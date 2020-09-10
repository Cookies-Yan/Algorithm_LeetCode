package leetCode.greedy_16;

import java.util.Arrays;

/**
 * Time O(nlogn)
 * Space O(1)
 */
public class M_452_MinimumNumberOfArrows {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> (a[0] - b[0])); //最小的来排序
        int res = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) { //第一个元素已经处理了
            if (points[i][0] > end) {
                res++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]); //应该去最小值，因为一但超出共工部分，一箭不能射下来全部的气球
            }
        }
        return res;
    }

}
