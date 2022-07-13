package greedy;

public class BestTimeToBuyAndSellStockII_122 {

    public static int maxProfit(int[] prices) {

        int profit = 0;
        boolean buy = false;
        int prevBuyPrice = 0;

        for (int i = 0; i < prices.length; i++) {

            if (!buy) {
                if (i + 1 < prices.length && prices[i] < prices[i + 1]) {
                    buy = true;
                    prevBuyPrice = prices[i];
                }
            } else {
                if (i + 1 < prices.length && prices[i] > prices[i + 1]) {
                    buy = false;
                    profit += (prices[i] - prevBuyPrice);
                }
                if (i == prices.length - 1 && buy) {
                    profit += (prices[i] - prevBuyPrice);
                }
            }

        }

        return profit;
    }

    public static void main(String[] args) {
        int ans = maxProfit(new int[]{5,6,2,3,1,2,5});
        System.out.println(ans);
    }
}
