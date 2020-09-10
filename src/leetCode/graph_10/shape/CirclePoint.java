package leetCode.graph_10.shape;

public class CirclePoint {
    /**
     * 解法一
     *给一个圆，半径和圆心点坐标，求有多少整数在圆内
     * @param r
     * @return
     */
    public int circlePoint (double r) {
        int res = 0;
        for (int x = 0; x <= r; x++) {
            int y = (int)Math.sqrt(r * r - x * x);
            res += y;
        }
        return res * 4 + 1;
    }

}
