package leetCode.backTracking_12;

import java.util.Arrays;

/**
 * 匈牙利算法解决最大匹配
 */
public class Hungary {

    int[] person;
    int[] places;

    public void match(int[][] matrix) {
        person = new int[4];
        places = new int[3];
        Arrays.fill(person, -1);
        Arrays.fill(places, -1);

        boolean[] visited;//让不让用visited判断
        int res = 0;
        /**
         * 每个人要遍历一遍，匹配一下
         */
        for (int i = 0; i < person.length; i++) {
            /**
             * 匈牙利算法，是否能匹配
             */
            visited = new boolean[places.length];
            if (hungary(matrix, i, visited)) {
                res++;
            }
        }
        System.out.println("res : " + res);
        System.out.println(Arrays.toString(person));
        System.out.println(Arrays.toString(places));
    }

    /**
     * start是哪个人去匹配
     * @param matrix
     * @param start
     * @param visited
     * @return
     */
    public boolean hungary(int[][] matrix, int start, boolean[] visited) {
        /**
         * 遍历三个地方
         */
        for (int end = 0; end < places.length; end++) {
            //没有边，或者已经访问过
            /**
             * 在矩阵中0，1，2，3，4，5，6
             * 4，5，6 是 end
             * 0，1，2，3 是 start 所以end + 4
             */
            if (matrix[start][end + 4] == 0 || visited[end]) {
                continue;
            }
            visited[end] = true;
            // 1.没有占用 2.是否可以让位置
            if (places[end] == -1 || hungary(matrix, places[end], visited)) {
                //person连到places, places连到person
                person[start] = end;
                places[end] = start;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
        };
        Hungary hungary = new Hungary();
        hungary.match(matrix);
    }
}
