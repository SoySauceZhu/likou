import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        // from 0 to 11 => 12 possible values
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int i = dp.length - 1; i >= num; i--) {
                // Backward traverse => 0/1 knapsack problem (no reuse)
                // Forward traverse => unbounded knapsack (allow reuse)
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[sum / 2];
    }

    public static void main(String[] args) {
        Solution416 solution416 = new Solution416();
        int[] nums = {1, 2, 5};
        System.out.println(solution416.canPartition(nums));
    }
}
