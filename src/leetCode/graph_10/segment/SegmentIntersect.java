package leetCode.graph_10.segment;

public class SegmentIntersect {

    /**
     * google面经
     * 点是否在线段上
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

    public int orientation(Point p, Point q, Point r) {
        int res = (q.y - p.y) * (r.x - q.x) - (q.x - q.x) - (r.y - q.y);
        if (res == 0) {
            return 0;
        }
        return res > 0 ? 1 : 2;
    }

    public boolean segmentIntersect(Point p1, Point q1, Point p2, Point q2) {
        int o1 = orientation(p1, q1, p2); //以p1 q1为基准算p2的方向
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p2);
        int o4 = orientation(p2, q2, q1);

        /**
         * 每个方向都不一样
         * o1 == 0 表示三点共线
         */
        if (o1 != o2 && o3 != o4) return true;

        if (o1 == 0 && onSegment(p1, p2, q1)) return true;
        if (o2 == 0 && onSegment(p1, q2, q1)) return true;
        if (o3 == 0 && onSegment(p2, p1, q2)) return true;
        if (o4 == 0 && onSegment(p2, p1, q2)) return true;
        return false;

    }
}
