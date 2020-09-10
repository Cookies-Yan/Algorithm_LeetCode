package algorithm.graph.shortestPath.dijkstra;


import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 邻接表的形式写Dijkstra
 *
 *  Adjacency List :
 *  O(VlogV) + O(ElogV) = O((E+V)logV) = O(ElogV)
 *  如果E是远远大于V的话：我们可以认为 O(ElogV)
 */
public class Dijkstra {

    public void dijkstra(Graph graph){

        boolean[] visited = new boolean[graph.vertices];
        int[] minDist = new int[graph.vertices];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int key1 = o1.getKey();
                int key2 = o2.getKey();
                return key1 - key2;
            }
        });

        minDist[0] = 0;
        pq.offer(new Pair<>(minDist[0], 0));//offer进去原点
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            int vertex = pair.getValue(); //把点拿出来
            visited[vertex] = true;
            List<Edge> list = graph.list[vertex];//把边拿出来
            for (int i = 0; i < list.size(); i++) {
                Edge edge = list.get(i);
                if(!visited[edge.end]) { //如果所到达的的这个点已经访问过就不考虑了
                    int destination = edge.end; //拿到到达点(1)   2------1
                    int curDist = minDist[vertex] + edge.weight; //原来到达该点的距离(不经过遍历点)+经过当前遍历点后到达destination的距离
                    if(curDist < minDist[destination]) {
                        /**
                         * 当前形式不能达到ElogV,因为存了相同的点的不同距离
                         *          0
                         *         / \
                         *     (6)/   \
                         *       1----2    对于同一个点，我们总会去最小的权值
                         *         (5)
                         * 本质上来说我们取不到6，但是我们没有把6干掉，直接把5加进去了，所以
                         * PriorityQueue的元素可能会大于V
                         */
                        pq.offer(new Pair<>(curDist, destination)); //如果小于，继续加入
                        minDist[destination] = curDist;  //更新
                    }
                }
            }
        }
        print(minDist);
    }

    public void print(int[] minDists) {

        System.out.println("Dijkstra : ");
        for(int i = 0; i < minDists.length; i++) {
            System.out.println("Source Vertex 0 :  to vertex" + i + " minDist : " + minDists[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0,1,4);
        graph.addEdge(0,2,3);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,2);
        graph.addEdge(2,3,4);
        graph.addEdge(2,4,3);
        graph.addEdge(3,4,2);
        graph.addEdge(3,5,1);
        graph.addEdge(4,5,6);
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph);
    }
}
