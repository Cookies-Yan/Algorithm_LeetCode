package leetCode.graph_10.M_323_NumberOfConnectedComponentsInAnUndirectedGraph;

public class M_323_QuickRank {
    /**
     * 节点个数
     */
    int count;
    int res;
    /**
     * 节点
     */
    private int[] parents;
    private int[] rank;

    public int countComponents(int n, int[][] edges) {

        res = n;
        this.count = n;
        parents = new int[count];
        this.rank = new int[count];

        /**
         * index: 0, 1, 2, 3, 4, 5
         * value: 0, 1, 2, 3, 4, 5
         */
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
        //遍历每个pair
        for(int[] pair : edges) {
            int xRoot = find(pair[0]);
            int yRoot = find(pair[1]);
            union(xRoot, yRoot);
        }
        return res;
    }
    //Time: O(h)
    //发生变化
    public void union(int x, int y) {
        int xRoot = find(x); //集合A
        int yRoot = find(y); //集合B
        if(xRoot == yRoot) {
            return;
        }
        if(rank[xRoot] < rank[yRoot]){
            //小高度union到大高度上，总高度不变
            parents[xRoot] = yRoot;
        } else if(rank[yRoot] < rank[xRoot]){
            //小高度union到大高度上，总高度不变
            parents[yRoot] = xRoot;
        } else {
            //高度相等,高度要加1
            parents[yRoot] = xRoot;
            rank[xRoot]++;
        }
        res--;
    }

    //Time: O(1)
    //找根节点,类似于索引堆
    //发生变化
    public int find(int index) {
        if(index < 0 || index >= count) {
            throw new IllegalArgumentException("越界");
        }
        while(index != parents[index]) {
            index = parents[index];
        }
        return index;

    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        M_323_QuickFind impl = new M_323_QuickFind();
        int res = impl.countComponents(5, edges);
        System.out.println(res);
    }
}
