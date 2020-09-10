package leetCode.graph_10.shape;

public class PointOnSegment {

    /**
     * 判断是否在x,和y的范围内，不能只判断x，因为不能排除垂直于x这种情况
     * @param p
     * @param q
     * @param r
     * @return
     */
    public boolean onSegment (Point p, Point q, Point r) {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x)
                && q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)) {
            return true;
        }
        return false;
    }

    /**
     * 判断C是否在AB(线段)上,判断是否共共线
     * @param C
     * @param A
     * @param B
     * @return
     */
    public boolean poingOnSegment (Point C, Point A, Point B) {

        Point AC = new Point(C.x - A.x, C.y - A.y);
        Point BC = new Point(C.x - B.x, C.y - B.y);
        int res = AC.x * BC.y - AC.y * BC.x;
        return res == 0 && onSegment(A, C, B);
    }
}
