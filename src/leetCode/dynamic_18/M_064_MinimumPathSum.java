package leetCode.dynamic_18;

public class M_064_MinimumPathSum {
    /**
     * Time O(n * m)
     * Space O(n)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        res[0] = grid[0][0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            res[0] = res[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                res[j] = grid[i][j] + Math.min(res[j - 1], res[j]);
            }
        }
        return res[n - 1];
    }

    /**
     * Time O(n * m)
     * Space O(1)
     * 直接在原数组里面改也行
     */
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                }
                if (i != 0 && j ==0) {
                    grid[i][j] += grid[i - 1][j];
                }
                if (i != 0 && j != 0) {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }

}
