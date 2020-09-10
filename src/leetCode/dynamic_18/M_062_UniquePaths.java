package leetCode.dynamic_18;

public class M_062_UniquePaths {

    /**
     * Time O(n * m)
     * Sapce O(n * m)
     * 例子：
     * [0, 0, 0, 0, 0, 0, 0]
     * [0, 0, 0, 0, 0, 0, 0]
     * [0, 0, 0, 0, 0, 0, 0]
     *          |
     * [1, 1, 1, 1, 1, 1, 1]
     * [1, 0, 0, 0, 0, 0, 0]
     * [1, 0, 0, 0, 0, 0, 0]
     *          |
     * [1, 1, 1, 1, 1, 1, 1]
     * [1, 2, 3, 4, 5, 6, 7]
     * [1, 3, 6, 10, 15, 21, 28]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }

    /**
     *
     * Time O(n * m)
     * Sapce O(n)
     * [1, 0, 0, 0, 0, 0, 0]
     * [1, 1, 0, 0, 0, 0, 0]
     * [1, 1, 1, 0, 0, 0, 0]
     * [1, 1, 1, 1, 0, 0, 0]
     * [1, 1, 1, 1, 1, 0, 0]
     * [1, 1, 1, 1, 1, 1, 0]
     * [1, 1, 1, 1, 1, 1, 1]
     * [1, 2, 1, 1, 1, 1, 1]
     * [1, 2, 3, 1, 1, 1, 1]
     * [1, 2, 3, 4, 1, 1, 1]
     * [1, 2, 3, 4, 5, 1, 1]
     * [1, 2, 3, 4, 5, 6, 1]
     * [1, 2, 3, 4, 5, 6, 7]
     * [1, 3, 3, 4, 5, 6, 7]
     * [1, 3, 6, 4, 5, 6, 7]
     * [1, 3, 6, 10, 5, 6, 7]
     * [1, 3, 6, 10, 15, 6, 7]
     * [1, 3, 6, 10, 15, 21, 7]
     * [1, 3, 6, 10, 15, 21, 28]
     */
    public int uniquePaths1(int m, int n) {
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] = res[j] + res[j - 1];
//                System.out.println(Arrays.toString(res));
            }
        }
        return res[n - 1];
    }

    /**
     * Time O(n)
     * Space O(1)
     * 数学解法
     * The problem is a classical combinatorial problem: there are h + v moves to do from start to finish,
     * h = m - 1 horizontal moves, and v = n - 1 vertical ones.One could choose when to move to the right,
     * i.e. to define h horizontal moves, and that will fix vertical ones. Or, one could choose when to move down,
     * i.e. to define v vertical moves, and that will fix horizontal ones.
     *
     * Combination(Count, k) = count! / (k!*(count - k)!) 转化
     * C = (count - k - 1) * (count - k + 2).... / k!
     *
     */
    public int uniquePaths2(int m, int n) {
        int count = m + n - 2;
        int k = m - 1;
        double res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (count - k + i) / i;
        }
        return (int)res;
    }

}
