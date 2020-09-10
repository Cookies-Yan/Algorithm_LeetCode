package algorithm.graph.shortestPath.dijkstra;

import java.util.Arrays;

/**
 * Matrix 的形式
 *
 * Adjacency Matrix : O(|V|^2)
 *
 */
public class Dijkstra2 {

    public void dijkstra2(int[][] matrix) {

        //a[][]的行数=  a.length
        //       列数=  a[].length
        int vertices = matrix.length;
        boolean[] visited = new boolean[vertices];
        int[] minDist = new int[vertices];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0; //初始化

        //之前是用PriorityQueue找最小值并进行提取,对于matrix，我们用for
        for (int i = 0; i < vertices; i++) {
            int vertex = getMinVertex(visited, minDist);
            visited[vertex] = true;
            for (int j = 0; j < vertices; j++) { //对于矩阵来说，改行非零的为有边存在
                if(!visited[j] && matrix[vertex][j] != 0) {
                    /**
                     * 松弛操作
                     */
                    int curDist = matrix[vertex][j] + minDist[vertex];
                    if (curDist < minDist[j]) {
                        minDist[j] = curDist;
                    }
                }
            }
        }
        print(minDist);
    }

    //找我们当前minDist最小值
    private int getMinVertex(boolean[] visited, int[] minDist) {
        int min = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i] && minDist[i] < min) {
                min = minDist[i];
                vertex = i;
            }
        }
        return vertex;
    }

    public void print(int[] minDists) {

        System.out.println("Dijkstra : ");
        for(int i = 0; i < minDists.length; i++) {
            System.out.println("Source Vertex 0 :  to vertex" + i + " minDist : " + minDists[i]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0, 4, 3, 0, 0, 0},
                {4, 0, 1, 2, 0, 0},
                {3, 1, 0, 4, 3, 0},
                {0, 2, 4, 0, 2, 1},
                {0, 0, 3, 2, 0, 6},
                {0, 0, 0, 1, 6, 0},
        };
        Dijkstra2 dijkstra2 = new Dijkstra2();
        dijkstra2.dijkstra2(matrix);
    }
}
