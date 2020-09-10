package algorithm.graph.shortestPath.bellmanFord;

import java.util.Arrays;

/**
 * 进行 V-1 次操作
 * 原因：图有n个点，又不能有回路，所以最短路径最多n-1边。又因为每次循环，至少relax一边所以最多n-1次就行了。
 * 面试不会考
 *
 * Time O(E * V)
 */
public class BellmanFord {

    public void bellmanFord(Graph graph) {
        int[] minDist = new int[graph.vertices];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        //从1开始，确保我们可以进行V-1次
        for (int i = 1; i < graph.vertices; i++) {
            //遍历我们所有的边
            for (int j = 0; j < graph.allEdges.size(); j++) {
                Edge edge = graph.allEdges.get(j);
                int start = edge.start;
                int end = edge.end;
                int weight = edge.weight;
                //松弛操作
                if (minDist[start] != Integer.MAX_VALUE && minDist[start] + weight < minDist[end]) {
                    minDist[end] = minDist[start] + weight;
                }
            }
        }
        /**
         * 判断是否有负权环,进行第V次迭代
         */
        for (int j = 0; j < graph.allEdges.size(); j++) {
            Edge edge = graph.allEdges.get(j);
            int start = edge.start;
            int end = edge.end;
            int weight = edge.weight;
            //松弛操作
            if (minDist[start] != Integer.MIN_VALUE && minDist[start] + weight < minDist[end]) {
                System.out.println("出现负权环");
            }
        }
        print(minDist);
    }

    public void print(int[] minDists) {

        System.out.println("BellmanFord : ");
        for(int i = 0; i < minDists.length; i++) {
            System.out.println("Source Vertex 0 :  to vertex" + i + " minDist : " + minDists[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(2,1,1);
        graph.addEdge(3,2,-2);
        graph.addEdge(1,3,2);
        graph.addEdge(4,3,-1);
        graph.addEdge(4,1,-4);
        graph.addEdge(5,4,1);
        graph.addEdge(0,5,8);
        graph.addEdge(0,1,10);
        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.bellmanFord(graph);
    }
}
