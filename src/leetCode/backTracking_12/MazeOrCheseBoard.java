package leetCode.backTracking_12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MazeOrCheseBoard {

    /**
     * 在做题当中输入尽量不要改变
     * 是否存在路径
     * 就用BFS
     * @param maze
     */
    public boolean hasPath(int[][] maze, int[] start, int[] end) {


        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        /**
         * 在做题当中输入尽量不要改变
         */
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Point> queue = new LinkedList<>();
        /**
         *将起点放到Queue之中
         */
        queue.offer(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.x == end[0] && cur.y == end[1]) {
                /**
                 * visited打印
                 */
                for (boolean[] visit : visited) {
                    System.out.println(Arrays.toString(visit));
                }
                return true;
            }

            for (int[] direction : directions) {
                int newX = cur.x + direction[0];
                int newY = cur.y + direction[1];
                /**
                 * 看visited是不是走过了
                 */
                if (isVaild(maze, newX, newY) && !visited[newX][newY]) {
                    queue.offer(new Point(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
        /**
         * visited打印
         */
        for (boolean[] visit : visited) {
            System.out.println(Arrays.toString(visit));
        }
        return false;
    }

    private boolean isVaild(int[][] maze, int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 1;
    }


    class Point{

        int x;
        int y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    /**
     * 计算路径距离
     * @param maze
     * @param start
     * @param end
     * @return
     */
    public int hasPath1(int[][] maze, int[] start, int[] end) {

        int res = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            /**
             * 如果计算距离，多出来的代码
             */
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();

                if (cur.x == end[0] && cur.y == end[1]) {

                    for (boolean[] visit : visited) {
                        System.out.println(Arrays.toString(visit));
                    }
                    /**
                     * 实际上数的是1的个数
                     */
                    return res - 1;
                }

                for (int[] direction : directions) {
                    int newX = cur.x + direction[0];
                    int newY = cur.y + direction[1];

                    if (isVaild(maze, newX, newY) && !visited[newX][newY]) {
                        queue.offer(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        /**
         * visited打印
         */
        for (boolean[] visit : visited) {
            System.out.println(Arrays.toString(visit));
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][]maze = new int[][] {
                {1, 1, 1, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
        };
        MazeOrCheseBoard mazeOrCheseBoard = new MazeOrCheseBoard();
        System.out.println(mazeOrCheseBoard.hasPath(maze, new int[]{0, 0}, new int[]{4, 4}));
        System.out.println(mazeOrCheseBoard.hasPath1(maze, new int[]{0, 0}, new int[]{4, 4}));

    }
}
