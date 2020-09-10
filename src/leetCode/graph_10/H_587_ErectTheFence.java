package leetCode.graph_10;

import java.util.*;

/**
 * Lc 输出结果改了
 */
public class H_587_ErectTheFence {
    //用到了stack
    //Time O(nlogn)
    //Space O(n)
    public List<Point> outerTrees(Point[] points) {
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x == 0 ? o1.y - o2.y : o1.x - o2.x; //x相同按y排，x不同按x排
            }
        });
        Stack<Point> stack = new Stack<>();
        for (int i = 0; i < points.length; i++) { //从左到右遍历
            while (stack.size() >= 2 && orientation(points[i],
                    stack.get(stack.size() - 2), stack.get(stack.size() - 1)) > 0){ //三个点的方向
                stack.pop();
            }
            stack.push(points[i]);
        }
        stack.pop(); //
        for (int i = points.length - 1; i >= 0; i--) { //从右到左遍历
            while (stack.size() >= 2 && orientation(points[i],
                    stack.get(stack.size() - 2), stack.get(stack.size() - 1)) > 0){ //三个点的方向
                stack.pop();
            }
            stack.push(points[i]);
        }
        return new ArrayList<>(new HashSet<>(stack)); //加点完全可以能重复，比如起点和终点会加两遍
    }

    private int orientation(Point p1, Point p2, Point p3) {
        return (p3.x - p2.x) * (p2.y - p1.y) - (p2.x - p1.x) * (p3.y - p2.y);
    }

    class Point {
        int x;
        int y;
        Point() {x = 0; y = 0;}
        Point(int a, int b) {x = a; y = b;}
    }
}
