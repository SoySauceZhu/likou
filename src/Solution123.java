public class Solution123 {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;   // My budget if I make 'first buy' operation on that day
        int firstSell = 0;                  // If I buy it and then sell on same day, I earn 0
        int secondBuy = Integer.MIN_VALUE;  // Worst case: Lots of money is removed from my budget
        int secondSell = 0;                 // Optimized Worst case: selling stock on the same day as buying

        for (int i : prices) {
            firstBuy = Math.max(firstBuy, -i);
            firstSell = Math.max(firstSell, i + firstBuy);
                    // At first sell, I earn: ( money I get on first buy (negative) + money I get today)
            secondBuy = Math.max(secondBuy, -i + firstSell);
            secondSell = Math.max(secondSell, i + secondBuy);
        }

        return secondSell;
    }

}
