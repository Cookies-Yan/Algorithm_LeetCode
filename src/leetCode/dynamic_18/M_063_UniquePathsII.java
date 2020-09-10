package leetCode.dynamic_18;

public class M_063_UniquePathsII {

    /**
     * 二维的
     * Time : O(n * m)
     * Space : O(n * m)
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        boolean m = false;
        boolean n = false;

        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
                m = true;
            }
            if (m) {
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }
        for (int i = 1; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
                n = true;
            }
            if (n) {
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] = 1;
            }
        }
        // for (int i = 0; i < row; i++) {
        //     System.out.println(Arrays.toString(obstacleGrid[i]));
        // }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[row - 1][col - 1];
    }
    /**
     *  一维
     *  Time : O(n * m)
     *  Space : O(n)
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] res = new int[col];
        res[0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                } else if (j > 0){
                    res[j] += res[j - 1];
                }
            }
        }
        return res[col - 1];
    }

}
