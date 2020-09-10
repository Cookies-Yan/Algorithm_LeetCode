package leetCode.graph_10;

import java.util.HashSet;

public class M_356_LineReflection {
    /**
     * Input: points = [[1,1],[-1,1]]
     * Output: true
     *
     * Input: points = [[1,1],[-1,-1]]
     * Output: false
     *
     * 1. 找出关于哪个轴堆成
     * x1 + x2 = c
     * min  max
     * min和max一定在在轴的两侧并且对称
     *
     * 2. check
     * x1 = c - x2
     * 平行于y轴 : x : 对称（两个点）
     *            y : 相同
     * HashSet
     *
     * EX: "1,1" "-1,1"  y坐标一定是相等的
     * x2 = sum - pair
     * Time : O(n)
     * Space : O(n)
     */
    public boolean isReflected(int[][] points) {
        HashSet<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] pair : points) {
            set.add(pair[0] + "," + pair[1]);
            min = Math.min(min, pair[0]);
            max = Math.max(max, pair[0]);
        }

        int sum = min + max;
        for (int[] pair : points) {
            if (!set.contains(sum - pair[0] + "," + pair[1])) {
                return false;
            }
        }
        return true;
    }

}
