package leetCode.graph_10.M_323_NumberOfConnectedComponentsInAnUndirectedGraph;

/**
 * Sample Input:
 * n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 */
public class M_323_QuickFind {

    int count;
    int res;
    private int[] id;

    public int countComponents(int n, int[][] edges) {

        res = n;
        this.count = n;
        id = new int[count];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        //遍历每个pair
        for(int[] pair : edges) {
            int A = find(pair[0]);
            int B = find(pair[1]);
            union(A, B);
        }
        return res;
    }

    public void union(int x, int y) {
        int A = find(x); //集合A
        int B = find(y); //集合B
        if(A == B) {
            return;
        }

        for(int i = 0; i < id.length; i++) {
            if(id[i] == A) {
                id[i] = B;
            }
        }
        //每Union一次就会少一个集合
        res--;
    }

    public int find(int index) {
        if(index < 0 || index >= count) {
            throw new IllegalArgumentException("越界");
        }
        return id[index];
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        M_323_QuickFind impl = new M_323_QuickFind();
        int res = impl.countComponents(5, edges);
        System.out.println(res);
    }


}
