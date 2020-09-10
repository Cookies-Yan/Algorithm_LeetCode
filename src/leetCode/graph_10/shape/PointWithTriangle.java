package leetCode.graph_10.shape;

public class PointWithTriangle {

    /**
     * 计算三角形面积
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @return
     */
    public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) /2.0;
    }
    public boolean isInside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
        double A = area(x1, y1, x2, y2, x3, y3);
        double A1 = area(x, y, x2, y2, x3, y3);
        double A2 = area(x1, y1, x, y, x3, y3);
        double A3 = area(x1, y1, x2, y2, x, y);

        /**
         * 点在三角形边上
         */
        if (A1 == 0 || A2 == 0 || A3 == 0) {
            return true;
        }

        /**
         * 点在三角形内部
         */
        return A == A1 + A2 + A3;
    }


}
