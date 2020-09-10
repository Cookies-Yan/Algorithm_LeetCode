package leetCode.graph_10;

public class M_365_WaterAndJugProblem {

    /**
     * Time < O(n)
     * Space O(n)
     *
     * Example 1: (From the famous "Die Hard" example)
     *
     * Input: x = 3, y = 5, z = 4
     * Output: True
     * Example 2:
     *
     * Input: x = 2, y = 6, z = 5
     * Output: False
     *
     * x * m + y * n = z
     * 3 * -2 + 5 * 2 = 4
     * + : 装水
     * - : 倒水
     *
     * x * m + y * n = z
     * 贝祖定理 : z = gcd(x,y) * i    z % gcd(x,y) = 0
     *
     * GCD : 求最大公约数(a,b)
     * 辗转相除发：
     * a / b = c...d
     * d = 0 : b
     *       : b / d = f...e
     * a = 3 b = 6
     *     6     3
     *     3     0
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;
        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
