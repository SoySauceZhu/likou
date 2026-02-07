public class Solution70 {
    // maintain a status matrix: dp[] -> {f(n-1), f(n)}
    // transfer:  {f(n-1), f(n)} * {{0, 1} = {f(n), f(n+1)}
    //                              {1, 1}}

    public int climbStairs(int n) {
        int[] dp = new int[]{1, 1};
        for (int i = 1; i < n; i++) {
            // dp * mat
            int next = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = next;
        }
        return dp[1];
    }

}
