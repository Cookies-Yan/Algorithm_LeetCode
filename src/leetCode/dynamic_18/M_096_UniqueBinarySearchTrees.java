package leetCode.dynamic_18;

public class M_096_UniqueBinarySearchTrees {
    /**
     * Time O(n)
     * Space O(n)
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     * n = 3
     * root : 1  left : 0 right : 2  f(0) * f(2);
     * root : 2  left : 1 right : 1  f(1) * f(1);
     * root : 3  left : 2 right : 0  f(2) * f(0);
     *
     * f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ... + f(n-2)*f(1) + f(n-1)*f(0)
     *
     */
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // res[j] 左孩子有多少个
                // res[i - j - 1]有孩子有多少个
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }
}
