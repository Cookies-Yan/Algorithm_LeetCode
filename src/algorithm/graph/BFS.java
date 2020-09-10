package algorithm.graph;
/**
 * BFS的复杂度和DFS一模一样，只是stack换成了Queue
 * 关于空间复杂度O（V）
 * 两种极限情况，一种是一层一个顶点，一共有n个，其空间复杂度一直为O（1）
 *             另一种是一共一层，一层n个，空间复杂度是O（n）
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    //邻接表,无sizen
    //几乎没有人用递归的方式实现BFS， 基本都是Iteration的方式
    /**
     * 下列代码块的结果：
     * 0
     *
     * 1
     *
     * 3
     *
     * 5
     *
     * 4
     *
     * 2
     * @param graphNode
     */
    public static void bfs1(GraphNode graphNode) {
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(graphNode);
        queue.offer(graphNode);

        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            System.out.println(node.label);
            for(GraphNode neighbor : node.neighbors) {
                if(!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
            System.out.println();
        }
    }

    //邻接表,size
    //下列代码块会吧一层的全部poll出
    //可以算最短距离，技巧在size对层数的控制，相当于步数
    /**
     * 下列代码块结果：
     * 0
     *
     * 1
     * 3
     * 5
     *
     * 4
     * 2
     * @param graphNode
     */
    public static void bfs2(GraphNode graphNode) {
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(graphNode);
        queue.offer(graphNode);

        while (!queue.isEmpty()) {
            //用size来控制层数，
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                GraphNode node = queue.poll();
                System.out.println(node.label);
                for(GraphNode neighbor : node.neighbors) {
                    if(!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            System.out.println();
        }
    }

    //Matrix,无size
    public static void bfsMatrix1(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    Integer vertex = queue.poll();
                    System.out.println(vertex);
                    for (int j = 0; j < matrix.length; j++) {
                        if(matrix[vertex][j] == 1) {
                            if (visited[j] == 0) {
                                queue.offer(j);
                                visited[j] = 1;
                            }
                        }
                    }
                }
            }
        }
    }

    //Matrix,有size
    public static void bfsMatrix2(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        Integer vertex = queue.poll();
                        System.out.println(vertex);
                        for (int j = 0; j < matrix.length; j++) {
                            if(matrix[vertex][j] == 1) {
                                if (visited[j] == 0) {
                                    queue.offer(j);
                                    visited[j] = 1;
                                }
                            }
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {

        GraphNode a = new GraphNode(0);
        GraphNode b = new GraphNode(1);
        GraphNode c = new GraphNode(2);
        GraphNode d = new GraphNode(3);
        GraphNode e = new GraphNode(4);
        GraphNode f = new GraphNode(5);

        //因为我们先按照bdf的顺序放入的ArrayList所以我们访问也是按照这个顺序访问的
        a.neighbors.add(b);
        a.neighbors.add(d);
        a.neighbors.add(f);

        b.neighbors.add(a);
        b.neighbors.add(e);
        b.neighbors.add(c);

        c.neighbors.add(b);
        c.neighbors.add(e);

        d.neighbors.add(a);
        d.neighbors.add(e);


        e.neighbors.add(d);
        e.neighbors.add(b);
        e.neighbors.add(c);

        f.neighbors.add(a);

//        bfs1(a);
//        bfs2(a);

        int[][] matrix = new int[][] {

                {0,1,0,1,0,1},
                {1,0,1,0,1,0},
                {0,1,0,0,1,0},
                {1,0,0,0,1,0},
                {0,1,1,1,0,0},
                {1,0,0,0,0,0},
        };

//        bfsMatrix1(matrix);
        bfsMatrix2(matrix);

    }
}
