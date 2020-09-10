package leetCode.dynamic_18;

import java.util.List;

public class M_120_Triangle {
    /**
     * Time O(n^2)
     * Space O(n)
     * 不一定每个行最小值相加就是最终结果
     *
     * 第i层找到了第j个元素
     * 那么第i + 1层 我们应该关注的元素应该是j和j+1
     *
     * 所以从下网上扫比较好
     *
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * res = [0, 0, 0, 0, 0]
     * res = [4, 1, 8, 3, 0]
     * res = [7, 6, 10, 0, 0]
     * res = [9, 10, 0, 0, 0]
     * res = [11, 0, 0, 0, 0]
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size() + 1]; // 防止最后一层越界 size+1
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}
