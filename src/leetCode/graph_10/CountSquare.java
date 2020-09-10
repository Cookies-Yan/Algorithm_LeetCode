package leetCode.graph_10;


import leetCode.graph_10.shape.Point;

import java.util.HashSet;
import java.util.List;

public class CountSquare {

    /**
     * 找到的正方形平行于x轴
     * @param list
     * @return
     */
    public int countSquare(List<Point> list) { //有若干个点
        if (list.size() == 0) return 0;
        /**
         * 两点确定一个正方形，两个for loop
         * 找对角线的两个点
         *          b
         *(x1,y1)+-------
         *               |
         *               |a
         *              (x2,y2)
         *我们需要 a边 = b边
         */
        int res = 0;
        HashSet<Point> set = new HashSet<>();
        for (Point point : list) {
            set.add(point);
        }

        HashSet<String> dup = new HashSet<>();//为了优化

        for (int i = 0; i < list.size(); i++) {
            Point node1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Point node2 = list.get(j);
                if (Math.abs(node1.x - node2.x) != Math.abs(node1.y - node2.y) //长方形没有这一行，
                        || (node1.x == node2.x && node1.y == node2.y)) {
                    continue;
                }
                Point left = new Point(node1.x, node2.y);
                Point right = new Point(node2.x, node1.y);
                if (set.contains(left) && set.contains(right)) {
                    /**
                     * 补充优化代码
                     */
                    long dis = (left.x - right.x) * (left.x - right.x) + (left.y - right.y) * (left.y - right.y);
                    //求出中心那点，这个点是是独一无二的
                    double centerX = (double)(left.x + right.x) / 2;
                    double centerY = (double)(left.y + right.y) / 2;
                    String info = "" + dis + "+" +  centerX + "+" + centerY;
                    if (!dup.contains(info)) {
                        dup.add(info);
                        res++;
                    }
                    /**
                     * 优化到此结束
                     * 如果没有优化，直接res++
                     */

                }
            }
        }
        /**
         * 我们可以不加上面补充(优化)的代码直接在结果res/2就可以了，以为一个正方形有两个对角线，所以进行了重复计算
         * 但是我们可以加上面你的优化代码，让我们的在代码内就判断出这个正方形已经算过了。
         */
        return res;
    }
}
