package algorithm.graph.prim;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 时间复杂度：
 * 每次确定（poll）一个点,确定一个点然后确定一个边（2E次), priorityQueue 取值(offer)logv
 * O(VlogV) + O(ElogV) = O((E+V)logV) = O(ElogV)
 * 如果E是远远大于V的话：我们可以认为 O(ElogV)
 * 空间复杂度：
 * O(n)
 */
public class Prim {

    public void primMST(Graph graph){
        //初始化都是False
        boolean[] visited = new boolean[graph.vertices];
        int [] minDists = new int[graph.vertices];
        int[] parents = new int[graph.vertices];

        //将minDists初始化为 INF， 表示刚开始的最短距离
        Arrays.fill(minDists, Integer.MAX_VALUE);
        //将parents初始化位-1
        Arrays.fill(parents, -1);

        /**
         * Pair: weight, Vertex
         * 按照权值从小到大进行排序，需要用到最小，所以用到priorityQueue的数据结构
         *
         * 在PriorityQueue中, graph.vertices指的是PriorityQue的Size()
         * Queue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>();
         *
         *
         * int compare(T o1, T o2) 是"比较o1和o2的大小"。
         * 返回"负数"，意味着"o1比o2小"；返回"0"，意味着"o1等于o2"；返回"正数"，意味着"o1大于o2"。
         */
        PriorityQueue<Pair<Integer, Integer>> priorityQueue =
                //
                new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
                    @Override
                    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                        int key1 = o1.getKey();
                        int key2 = o2.getKey();
                        return key1 - key2;//从小到大排序
                    }
                });
        minDists[0] = 0;
        priorityQueue.offer(new Pair<>(minDists[0], 0));
        while(!priorityQueue.isEmpty()) {
            //先将自身的点记录
            Pair<Integer, Integer> pair = priorityQueue.poll();
            int vertex = pair.getValue();
            visited[vertex] = true;
            //拿到所有点的边，因为每个点都对应了一个list来存边
            List<Edge> list = graph.list[vertex];
            //遍历一下当前的边
            for(int i = 0; i < list.size(); i++) {
                //拿出来一个边
                Edge edge = list.get(i);
                //去除所有visited 的点
                if(!visited[edge.end]) {
                    int destination = edge.end;
                    int curDist = edge.weight;
                    //小于的话我们再进行加入,下面写的不是完全严格的prim算法，边并不是严格的V个
                    //因为我们没有通过小weigh的边替代大weight的边
                    if(curDist < minDists[destination]) {
                        priorityQueue.offer(new Pair<>(curDist, destination));
                        parents[destination] = vertex;
                        minDists[destination] = curDist;
                    }
                }
            }
        }
        print(parents, minDists, graph.vertices);

    }

    public void print(int[] parents, int[] minDists, int vertice) {

        int total = 0;
        System.out.println("MST : ");
        for(int i = 1; i < parents.length; i++) {
            System.out.println("Edge : " + i + " - " + parents[i] + " minDist : " + minDists[i]);
            total += minDists[i];
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
        Prim prim = new Prim();
        prim.primMST(graph);
    }
}
