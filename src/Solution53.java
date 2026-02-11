public class Solution53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length + 1];    // The max sum of sequence that ended with i;
        for (int i = 0; i < nums.length; i++) {

            // continue
            int use = dp[i] + nums[i];

            // restart
            int notUse = nums[i];

            dp[i+1] = Math.max(use, notUse);

            max = Math.max(max, dp[i+1]);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution53 s = new Solution53();
        int[] nums = new int[]{-1};

        System.out.println(s.maxSubArray(nums));
    }

}
