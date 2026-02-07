public class Solution198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            // for each house, you can choose steal or not
            int steal = dp[i - 2] + nums[i-1];
            int noSteal = dp[i - 1];

            dp[i] = Math.max(steal, noSteal);
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Solution198 s = new Solution198();
        int[] a = new int[]{2, 1, 1, 2};
        System.out.println(s.rob(a));
    }
}
