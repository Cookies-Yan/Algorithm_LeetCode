package leetCode.array_04;

public class M_073_SetMatrixZeroes {

    /**
     * Time O(n * m)
     * Space O(1)
     * 如果没有boolean这个判断，那么就是在下面的case出错，因为本身第0列或者第0行就有0
     * Input:
     *      [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * Output:
     *      [[0,0,0,0],[0,0,0,0],[0,0,0,0]]
     * Expected:
     *      [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) row = true; //因为有一个corner case见上面
                    if (j == 0) col = true;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
