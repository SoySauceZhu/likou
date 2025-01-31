public class Solution121 {
    /*
    def maxProfit(prices):
        buy = float('-inf')  # Most negative value, no stock bought yet
        sell = 0  # No profit yet

        for price in prices:
            buy = max(buy, -price)  # Buy at the lowest possible price
            sell = max(sell, buy + price)  # Sell at the highest possible profit

        return sell
     */


    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        Solution121 solution121 = new Solution121();
        System.out.println(solution121.maxProfit(prices));
    }
}
