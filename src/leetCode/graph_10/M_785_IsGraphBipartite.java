package leetCode.graph_10;

import java.util.LinkedList;
import java.util.Queue;

public class M_785_IsGraphBipartite {

    public static boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        //着色 red:1  black: -1
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0) {
                //广度优先遍历 用queue实现
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                colors[i] = 1; //-1也可以
                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    for (int adjacent : graph[node]) {
                        if (colors[adjacent] == colors[node]) {
                            return false;
                        } else if (colors[adjacent] == 0) {
                            queue.offer(adjacent);
                            colors[adjacent] = -colors[node];
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(nums));


    }

}
