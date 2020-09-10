package leetCode.dynamic_18;

public class E_122_BestTimeToBuyAndSell {

    /**
     * Time O(n)
     * Space O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

}
