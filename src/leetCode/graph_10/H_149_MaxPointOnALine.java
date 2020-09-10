package leetCode.graph_10;

import leetCode.graph_10.shape.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * 求斜率的问题:
 * 1. 在x轴
 * 2. 相同点
 * 3. 精度问题(GCD) 1/3 1/3
 *
 * 不求斜率，所以不能确定两点，把其他点代入，不能用斜率去计算某些东西，可用到它，不需要用它计算
 * 避免精度不足，我们用HashMap来解决
 * <斜率，点的个数> 我们用斜率去比较，但不用斜率参与计算
 * 将斜率的分数化简存为String,就可以避免精确度的问题，GCD
 * 老版本，一维数组
 *
 * Time O(n^2)
 * Space O(n)
 */
public class H_149_MaxPointOnALine {

    public int maxPoint(Point[] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length < 2) return points.length;
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int samePoint = 0;
            int sameXAxis = 1; //点本身
            for (int j = 0; j < points.length; j++) {
                /**
                 * 可能有相同点(3,4)出现多于2次
                 */
                if (i != j) {
                    if (points[i].x == points[j].x && points[i].y == points[j].y) {
                        samePoint++;
                    }
                    if (points[i].x == points[j].x) {
                        sameXAxis++;
                        continue;
                    }
                    int numberator = points[i].y - points[j].y; //分子
                    int denominator = points[i].x - points[j].x; //分母
                    int gcd = gcd(numberator, denominator);
                    String hashStr = (numberator / gcd) + "/" + (denominator / gcd);//利用最大公约数，化成最简
                    map.put(hashStr, map.getOrDefault(hashStr, 1) + 1);
                    res = Math.max(res, map.get(hashStr) + samePoint);
                }
            }
            res = Math.max(res, sameXAxis); //看到底是垂直于X轴的点多，还是不垂直的点多
        }
        return res;
    }

    /**
     * 斜率和gcd是捆绑到一起的，一般都是一起计算的，都要用到。
     * 辗转相除
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    /**
     * 新版本，二维数组ß
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Map<Integer, Integer>, Integer> m = new HashMap<>();
            int duplicate = 1;
            for (int j = i + 1; j < points.length; ++j) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    ++duplicate; continue;
                }
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int d = gcd(dx, dy);
                Map<Integer, Integer> t = new HashMap<>();
                t.put(dx / d, dy / d);
                m.put(t, m.getOrDefault(t, 0) + 1);
            }
            res = Math.max(res, duplicate);
            for (Map.Entry<Map<Integer, Integer>, Integer> e : m.entrySet()) {
                res = Math.max(res, e.getValue() + duplicate);
            }
        }
        return res;
    }
}
