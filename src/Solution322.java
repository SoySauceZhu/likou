import java.util.*;

public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Set<Integer> coinSet = new HashSet<>();
        for (int c : coins) {
            coinSet.add(c);
        }
        int[] dp = new int[amount + 1];     // Least # of combo to reach `i`$
        Deque<Integer> lastReachableStack = new ArrayDeque<>();
        lastReachableStack.add(0);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int minStep = Integer.MAX_VALUE;
            for (int lastReachable : lastReachableStack) {
                int difference = i - lastReachable;
                if (coinSet.contains(difference)) {
                    minStep = Math.min(minStep, dp[lastReachable] + 1);
                }
            }

            if (minStep == Integer.MAX_VALUE) minStep = -1;
            dp[i] = minStep;
            lastReachableStack.push(i);
        }


        return Math.max(dp[dp.length - 1], -1);
    }

    public static void main(String[] args) {
        Solution322 s = new Solution322();
//
//        int[] coins1 = {1, 2, 5};
//        int amount1 = 11;
//        System.out.println("Test 1 expected=3 actual=" + s.coinChange(coins1, amount1));
//
        int[] coins2 = {2};
        int amount2 = 1;
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
