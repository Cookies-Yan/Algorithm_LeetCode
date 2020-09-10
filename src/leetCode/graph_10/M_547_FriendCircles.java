package leetCode.graph_10;

/**
 * Time(n) = c + n^2*log(n) + n = O(n^2*log(n))
 * Space(n) = 2n = O(n)
 */
public class M_547_FriendCircles {

    public static int[] parents;
    public static int[] rank;


    public static int findCircleNum(int[][] M) {

        if(M == null || M.length == 0 || M[0].length == 0
                || M.length != M[0].length)  return 0;

        int N = M.length;
        parents = new int[N];
        rank = new int[N];

        for(int i = 0; i < N; i++) {
            parents[i] = i;
            rank[i] = 1;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                if (M[i][j] == 1 && i != j) {
                    union(i, j);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < parents.length; i++) {
            if (i == parents[i]) {
                ans += 1;
            }
        }
        return ans;
    }

    public static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        if (rank[xRoot] > rank[yRoot]) parents[yRoot] = xRoot;
        if (rank[xRoot] < rank[yRoot]) parents[xRoot] = yRoot;
        if (rank[xRoot] == rank[yRoot]) {
            parents[xRoot] = yRoot;
            rank[yRoot]++;
        }
    }

    public static int find(int index) {
        if(index < 0) {
            throw new IllegalArgumentException("Over Bound");
        }
        while(index != parents[index]) {
            index =  parents[index];
        }
        return index;
    }

    public static void main(String[] args) {
        int[][] friend = new int[][] {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1},
        };
        int res = findCircleNum(friend);
        System.out.println(res);
    }

}
