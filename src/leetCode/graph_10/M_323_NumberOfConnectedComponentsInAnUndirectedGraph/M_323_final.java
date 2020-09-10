package leetCode.graph_10.M_323_NumberOfConnectedComponentsInAnUndirectedGraph;

/**
 * 最终优化版本
 */
public class M_323_final {

    public int countComponents(int n, int[][] edges) {
        int res = n;
        int[] parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;

        }
        for(int[] pair : edges) {
            int x = find(parents, pair[0]);
            int y = find(parents, pair[1]);
            if(x != y) {

                parents[x] = y;
                res--;
            }

        }
        return res;
    }

    //效率高，面试官不一定看得懂
    private  int find(int[] parents, int index) {
        while (index != parents[index]) {
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }

    //面试中完全可以写
    public int find2(int[] parents, int index) {

        while(index != parents[index]) {
            index = parents[index];
        }

        return index;

    }
}
