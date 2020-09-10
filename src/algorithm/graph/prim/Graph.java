package algorithm.graph.prim;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    int vertices;

    //例如0这个点 后面接的各个点
    List<Edge>[] list;

    public Graph(int vertices) {
        this.vertices = vertices;
        list = new ArrayList[vertices];

        //我们把所有点后面都给上list
        for(int i = 0; i < vertices; i++) {
            list[i] = new ArrayList<>();
        }
    }

    public void addEdge(int start, int end, int weight) {
        //无向图等于双向有向图，所以往返都要加
        Edge edge = new Edge(start, end, weight);
        list[start].add(edge);

        edge = new Edge(end, start, weight);
        list[end].add(edge);
    }

}
