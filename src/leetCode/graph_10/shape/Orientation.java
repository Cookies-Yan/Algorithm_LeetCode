package leetCode.graph_10.shape;

public class Orientation {

    /**
     * 判断顺时针和逆时针
     * @param p
     * @param q
     * @param r
     * @return
     */
    public int orientation(Point p, Point q, Point r) {
        int res = (q.y - p.y) * (r.x - q.x) - (q.x - q.x) - (r.y - q.y);
        if (res == 0) {
            return 0;
        }
        return res > 0 ? 1 : 2;
    }
}
