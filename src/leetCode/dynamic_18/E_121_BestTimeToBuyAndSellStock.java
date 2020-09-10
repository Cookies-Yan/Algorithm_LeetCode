package leetCode.dynamic_18;

public class E_121_BestTimeToBuyAndSellStock {
    /**
     * Time O(n)
     * Space O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }

    /**
     * 更快一点
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int profit = 0;
        for (int price : prices) {
            if (price > min) {
                profit = Math.max(profit, price - min);
            } else {
                min = price;
            }
        }
        return profit;
    }
}
