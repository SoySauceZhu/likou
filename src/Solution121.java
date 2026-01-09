public class Solution121 {

    public int maxProfit(int[] prices) {
        int lower = prices[0];      // Lowest price before prices[i]
        int maxProfit = 0;
        for (int price : prices) {
            if (price < lower) {
                lower = price;
            }

            // Max Profit sell at day_i = price[i] - lowest_prefix_price
            // Update possible max profict
            if (price - lower > maxProfit) {
                maxProfit = price - lower;
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


//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        int minPrice = Integer.MAX_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < minPrice) {
//                minPrice = prices[i];
//            }
//
//            if (prices[i] - minPrice > maxProfit) {
//                maxProfit = prices[i] - minPrice;
//            }
//        }
//        return maxProfit;
//    }