package leetCode.backTracking_12;

import java.util.LinkedList;
import java.util.Queue;

public class M_200_NumberOfIslands {
    /**
     * DFS
     * Time O(m * n)最差情况
     * Space O(m * n)
     */
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    /**
                     * 想用BFS就调用BFS
                     */
                    floodfillBfs(grid, i, j);
//                    floodfillDfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void floodfillDfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        floodfillDfs(grid, i, j + 1);
        floodfillDfs(grid, i, j - 1);
        floodfillDfs(grid, i + 1, j);
        floodfillDfs(grid, i - 1, j);

    }

    /**
     * BFS
     * Time O(m * n)
     * Space 具体分析
     * @param grid
     * @param x
     * @param y
     */
    public void floodfillBfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        Queue<Integer> queue = new LinkedList<>();
        /**
         * 二维坐标转一维
         */
        queue.offer(x * n + y);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            /**
             * 一维坐标转2维坐标
             */
            int i = cur / n;
            int j = cur % n;
            /**
             * 以下分别为上下左右四个方向
             */
            if (i > 0 && grid[i - 1][j] == '1') {
                queue.offer((i - 1) * n + j);
                grid[i - 1][j] = '0';
            }
            if (i < m - 1 && grid[i + 1][j] == '1') {
                queue.offer((i + 1) * n + j);
                grid[i + 1][j] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1') {
                queue.offer(i * n + j - 1);
                grid[i][j - 1] = '0';
            }
            if (j < n - 1 && grid[i][j + 1] == '1') {
                queue.offer(i * n + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }

    /**
     * BFS优化后的写法
     * 复杂度同上
     * @param grid
     * @param x
     * @param y
     */
    public void floodfillBfs2(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int[] direction : directions) {
                int newX = cur.x + direction[0];
                int newY = cur.y + direction[1];
                if (isVaild(grid, newX, newY)) {
                    queue.offer(new Point(newX, newY));
                    grid[newX][newY] = '0';
                }
            }
        }
    }

    private boolean isVaild(char[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1';
    }


    class Point{

        int x;
        int y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
