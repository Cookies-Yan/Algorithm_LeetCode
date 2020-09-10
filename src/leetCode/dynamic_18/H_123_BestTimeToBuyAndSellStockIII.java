package leetCode.dynamic_18;

public class H_123_BestTimeToBuyAndSellStockIII {
    /**
     * Time O(n)
     * Space O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;
        for (int price : prices) {
            sell2 = Math.max(sell2, buy2 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, buy1 + price);
            buy1 = Math.max(buy1, -price);
        }
        return sell2;
    }

    /**
     * 另一种方法
     * [3,3,5,0,0,3,1,4]
     * 将数组分为两段，每一段的最大值相加的最大值就是最大利润
     * [0, 0, 2, 2, 2, 3, 3, 4] 从左往右走
     * [4, 4, 4, 4, 4, 3, 3, 0] 从右往左走
     * 因为第二次要根据第一次的买点进行反着计算，所以从右往左走
     * [4, 4, 6, 6, 6, 6, 6, 4]
     * output = 6
     *
     * Time O(n)
     * Space O(n)
     * @param
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[] array2 = new int[n];
        int[] array1 = new int[n];

        int lowest = prices[0];
        for (int i = 1; i < n; i++) {
            // if (prices[i] > lowest) { // 不能加判断, 加判断不能给出数组DP效果
            array1[i] = Math.max(array1[i - 1], prices[i] - lowest);
            // } else {
            lowest = Math.min(lowest,prices[i]);
            // }
        }

        int highest = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // if (prices[i] < highest) {
            array2[i] = Math.max(array2[i + 1], highest - prices[i]);
            // } else {
            highest = Math.max(highest, prices[i]);
            // }
        }
//        System.out.println(Arrays.toString(array1));
//        System.out.println(Arrays.toString(array2));
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, array1[i] + array2[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        H_123_BestTimeToBuyAndSellStockIII a = new H_123_BestTimeToBuyAndSellStockIII();
        int[] b = {3,3,5,0,0,3,1,4};
        System.out.println(a.maxProfit(b));

    }
}
