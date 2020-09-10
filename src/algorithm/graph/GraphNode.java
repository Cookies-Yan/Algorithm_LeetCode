package algorithm.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    int label;

    public List<GraphNode> neighbors;

    public GraphNode(int label) {

        this.label = label;
        neighbors = new ArrayList<>();

    }

}
