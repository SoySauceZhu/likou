import java.util.*;

public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Set<Integer> coinSet = new HashSet<>();
        for (int c : coins) {
            coinSet.add(c);
        }
        int[] dp = new int[amount + 1];     // Least # of combo to reach `i`$

        for (int n = 1; n < dp.length; n++) {
            int count = Integer.MAX_VALUE;

            // find min(dp[n-c] + 1)
            for (int c : coins) {
                if (n - c >= 0 && dp[n-c] != -1) {
                    count = Math.min(count, dp[n - c] + 1);
                }
            }

            if (count == Integer.MAX_VALUE) count = -1;

            dp[n] = count;
        }

        return (dp[amount] == Integer.MAX_VALUE || dp[amount] == 0) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution322 s = new Solution322();

//        int[] coins1 = {1, 2, 5};
//        int amount1 = 11;
//        System.out.println("Test 1 expected=3 actual=" + s.coinChange(coins1, amount1));
//
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Test 2 expected=-1 actual=" + s.coinChange(coins2, amount2));

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Test 3 expected=0 actual=" + s.coinChange(coins3, amount3));

        int[] coins4 = {1};
        int amount4 = 2;
        System.out.println("Test 4 expected=2 actual=" + s.coinChange(coins4, amount4));

        int[] coins5 = {186, 419, 83, 408};
        int amount5 = 6249;
        System.out.println("Test 5 expected=20 actual=" + s.coinChange(coins5, amount5));
    }
}
