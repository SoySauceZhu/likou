import java.util.*;

/*

Knapsack

Backward to prevent reuse
Forward to allow reuse

 */

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
        int[] nums = {1, 5, 5, 11};
        System.out.println(solution416.partition(nums));
    }

    public boolean partition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0) {
            return false; // If total sum is odd, partition is impossible
        }

        int target = totalSum / 2;
        int n = nums.length;

        // DP array: dp[j] is true if sum j can be formed
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case

        // Map to track subsets forming a sum
        Map<Integer, List<Integer>> subsetMap = new HashMap<>();
        subsetMap.put(0, new ArrayList<>()); // Empty subset for sum 0

        for (int num : nums) {
            // Traverse in reverse to avoid reusing the same number
            for (int j = target; j >= num; j--) {
                if (dp[j - num]) { // If sum (j - num) was previously possible
                    dp[j] = true;

                    // Create a new subset by adding 'num' to the subset forming (j - num)
                    List<Integer> newSubset = new ArrayList<>(subsetMap.get(j - num));
                    newSubset.add(num);
                    subsetMap.put(j, newSubset);
                }
            }
        }

        if (!dp[target]) {
            return false; // No valid partition
        }

        // Retrieve one valid subset
        List<Integer> subset1 = subsetMap.get(target);
        List<Integer> subset2 = new ArrayList<>();

        // Remove subset1 elements from subset2
        for (int num : nums) {
            if (!subset1.contains(num)) {
                subset2.add(num);
            }
        }

        // Print the partitioned subsets
        System.out.println("Partition Found: ");
        System.out.println("Subset 1: " + subset1);
        System.out.println("Subset 2: " + subset2);

        return true;
    }
}
