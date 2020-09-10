package leetCode.graph_10.M_323_NumberOfConnectedComponentsInAnUndirectedGraph;

public class M_323_QuickUnion {
    int count;
    int res;
    private int[] parents;

    public int countComponents(int n, int[][] edges) {

        res = n;
        this.count = n;
        parents = new int[count];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
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
        parents[xRoot] = yRoot;
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
