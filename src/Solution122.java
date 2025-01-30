public class Solution122 {
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

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        Solution122 solution122 = new Solution122();
        System.out.println(solution122.maxProfit(prices));
    }
}
