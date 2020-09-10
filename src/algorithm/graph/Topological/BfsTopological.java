package algorithm.graph.Topological;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 210 BFS 实现方法
 * Time: O(V+E), 同BFS
 */
public class BfsTopological {

    //本题不需要转化成图的形式
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] res = new int[numCourses];    //存入最终排序结果
        int k = 0;  //控制输入结果数组的指针res
        /**
         *计算入度
         */
        int[] indegree = new int[numCourses];   //将计算的入度，存入数组
        for (int[] pair : prerequisites) {      //入度计算，
            indegree[pair[0]]++;                //没有在第一个列出现的，即为不需要有preCourse的
        }

        //进行BFS遍历,我们利用indegree代替了之前所用的HashSet查重的功能
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {     //把入度为0的加入Queue
            if(indegree[i] == 0) {
                queue.offer(i);
                res[k++] = i;
            }
            
        }

        //对Queue中的元素进行操作
        while (!queue.isEmpty()) {
            int pre = queue.poll();     //拿出入度为0的元素，然后找其相邻的边
            for(int[] pair : prerequisites) {
                if(pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {   //如果去掉pre,入度为0，继续加入Queue中
                        queue.offer(pair[0]);
                        res[k++] = pair[0];         //将入度为0的元素加入res数组
                    }
                }
            }
        }

        /**
         * 如果结果数组等于输入的节点数（即课程数）那么就认为所有点都走到了，没有出现环
         * 对于LC 207题，只需要把最后一行改为
         * return (k == numCourses) ? true : false;
         */
        return (k == numCourses) ? res : new int[0];    //判断有无环
    }

}
