package leetCode.binarySearch_05;

public class M_498_DiagonalTraverse {
    /**
     *  Time O(m * n)
     *  Space O(m * n)
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}}; //方向，往斜上方走还是斜下方走

        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];
            //如果越界需要转换方向
            if (row >= m) { //必须要写在前面
                row = m - 1; col += 2; d = 1 - d;
            }
            if (col >= n) {
                col = n - 1; row += 2; d = 1 - d;
            }
            if (row < 0) {
                row = 0; d = 1 - d; //变方向
            }
            if (col < 0) {
                col = 0; d = 1 - d;
            }
        }
        return res;
    }
}
