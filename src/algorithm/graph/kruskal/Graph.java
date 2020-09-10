package algorithm.graph.kruskal;

import java.util.ArrayList;

//跟之前不一样了，因为我们要知道所有的边
public class Graph {

    int vertices;

    ArrayList<Edge> allEdges;

    public Graph(int vertices) {
        this.vertices = vertices;
        allEdges = new ArrayList<>();
    }

    public void addEdge(int start, int end, int weight) {
        Edge edge = new Edge(start, end, weight);
        allEdges.add(edge);
    }
}
