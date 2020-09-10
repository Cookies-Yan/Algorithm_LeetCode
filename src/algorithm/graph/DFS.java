package algorithm.graph;

/**
 * 分析递归调用的时间空间复杂度，不能直接计算，需要将图画图分析内部逻辑，一步一步推理
 * DFS递归调用GraphNode的         Time:O(V+2E) = O(V+E)，
 * 如果是递归调用来计算矩阵形式的图，Time:O（V**2),相当于把二维数组的点都走了一遍
 *                              Space:O(V)，矩阵也相同
 * 关于空间复杂度，我们进入Recursion的次数就是其Vertex的个数，因为每个节点都需要用recursion去取舍下一步
 */

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class DFS {
    /**
     * 下面代码块的Time: O(V)
     * 因为把所有的Vertex都走了一遍
     * @param list
     */
    //邻接表
    //我们不知道这个图到底是不是连通的，完美的DFS
    public static void dfs(List<GraphNode> list) {
        //所有的 DFS都要判断一下当前的节点到底有没有加入,也就是我们之前到底遍历过了没有
        //在这里我们用HashSet来存储我们访问过的路径，当然我们也可以使用array
        HashSet<GraphNode> visited= new HashSet<>();
        //在此我们不知道图是否是联通的，所以要遍历
        for(GraphNode node : list) {
            if(!visited.contains(node)) {
                helper(node, visited);
            }
        }
    }

    //我们知道是个连通图，面试的时候
    public static void dfs2(GraphNode node) {
        helper(node, new HashSet<>());
    }

    /**
     * 下面代码块Time:O(2E)
     * 因为我们遍历了所有的边，但是我们需要遍历边两遍才能知道是否走过该顶点
     * @param node
     * @param visited
     */
    //邻接表版本
    //我们把当前GraphNode放进去，然后放进HashSet
    //Class版本，递归
    public static void helper(GraphNode node , HashSet<GraphNode> visited) {
        visited.add(node);
        System.out.println(node.label);
        for(GraphNode neighbor : node.neighbors) {
            if(!visited.contains(neighbor)) {
                helper(neighbor,visited);
            }
        }

    }

    //我们转换成迭代，利用stack，邻接表
    public static void dfsIteration(GraphNode graphNode) {
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> visited = new HashSet<>();
        stack.push(graphNode);
        visited.add(graphNode);
        while (!stack.isEmpty()) {
            GraphNode node = stack.pop();
            System.out.println(node.label);
            for(GraphNode neighbor : node.neighbors) {
                if(!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    //以数组的情况实现，递归
    //Matrix版本,matrix.length是matrix行的个数
    public static void dfsMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) {
                helper(matrix, visited, i);
            }
        }
    }

    public static void helper(int[][] matrix, int[] visited, int vertex) {
        visited[vertex] = 1;
        System.out.println(vertex);
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[vertex][i] == 1) {
                if (visited[i] == 0) {
                    helper(matrix, visited, i);
                }
            }
        }
    }

    //Matrix写法，迭代
    public static void dfsMatrixIteration(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                stack.push(i);
                while (!stack.isEmpty()) {
                    Integer vertex = stack.pop();
                    System.out.println(vertex);
                    for (int j = 0; j < matrix.length; j++) {
                        if(matrix[vertex][j] == 1) {
                            if (visited[j] == 0) {
                                stack.push(j);
                                visited[j] = 1;
                            }
                        }
                    }
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

        int[][] matrix = new int[][] {

                {0,1,0,1,0,1},
                {1,0,1,0,1,0},
                {0,1,0,0,1,0},
                {1,0,0,0,1,0},
                {0,1,1,1,0,0},
                {1,0,0,0,0,0},
        };
        dfsMatrixIteration(matrix);
//        dfsIteration(a);
//        dfsMatrix(matrix);
//        dfs2(a);
    }
}
