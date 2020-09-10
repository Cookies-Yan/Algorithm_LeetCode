package leetCode.math_03;

/**
 * Time O(n)
 * Space O(1)
 */
public class M_573_SquirrelSimulation {

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int total = 0;
        int dis = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            total += distance(nut, tree) * 2; //从树到坚果的距离
            // x + x - x - y > 0 ==> x - y > 0
            // dis越大 说明松鼠到第一个坚果的距离越小
            dis = Math.max(dis, distance(nut, tree) - distance(nut, squirrel));
        }
        return total - dis;
    }

    public int distance(int[] a, int[] b) { return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]); }
}
