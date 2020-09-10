package algorithm.graph.kruskal;

import algorithm.unionFind.impl.PathCompressionImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 时间复杂度：
 * O(ElogE)
 */
public class Kruskal {

    public void kruskalMST(Graph graph) {

        //所有的边进行排序
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        //把所有的边加入priorityQueue
        priorityQueue.addAll(graph.allEdges);

        List<Edge> res = new ArrayList<>();
        PathCompressionImpl unionFind = new PathCompressionImpl(graph.vertices);
        //componets来判断结束循环
        int components = graph.vertices;

        while (!priorityQueue.isEmpty()) {
            //如果只有一个点，可能减完等于0，所以写小于等于1
            if (components <= 1) {
                break;
            }
            Edge edge = priorityQueue.poll();
            //判断是否相连形成环，如果形成，则跳过
            if (unionFind.connected(edge.start, edge.end)) {
                continue;
            }
            unionFind.union(edge.start, edge.end);
            components--;
            res.add(edge);
        }
        print(res);
    }
    public void print(List<Edge> list) {
        int total = 0;
        System.out.println("MST : ");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("Edge : " + list.get(i).start + " - " + list.get(i).end + " weight : " + list.get(i).weight);
            total += list.get(i).weight;
        }
        System.out.println("Total : " + total);
    }

    public static void main(String[] args) {

        Graph graph = new Graph(6);
        graph.addEdge(0,1,6);
        graph.addEdge(0,2,1);
        graph.addEdge(0,3,5);
        graph.addEdge(1,2,5);
        graph.addEdge(1,4,3);
        graph.addEdge(2,4,6);
        graph.addEdge(2,3,5);
        graph.addEdge(2,5,4);
        graph.addEdge(3,5,2);
        graph.addEdge(4,5,6);
        Kruskal kruskal = new Kruskal();
        kruskal.kruskalMST(graph);
    }
}
