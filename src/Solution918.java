public class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        /* Intuition
            1. If subarray doesn't cross the boundary: same as solution53
            2. If subarray cross the boundary: First find minimum series sum.
                                                Then subtract the total sum with the partial sum.
         */

        int[] maxSeqSumEndWith = new int[nums.length + 1];
        int[] minSeqSumEndWith = new int[nums.length + 1];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            // continue sequence
            int con_max = maxSeqSumEndWith[i] + nums[i];
            int con_min = minSeqSumEndWith[i] + nums[i];

            // restart
            int res_max = nums[i];
            int res_min = nums[i];

            minSeqSumEndWith[i + 1] = Math.min(res_min, con_min);
            min = Math.min(min, minSeqSumEndWith[i + 1]);

            maxSeqSumEndWith[i + 1] = Math.max(res_max, con_max);
            max = Math.max(max, maxSeqSumEndWith[i + 1]);
        }

        if (max < 0) return max;
        return Math.max(max, totalSum - min);


    }

    public static void main(String[] args) {
        Solution918 s = new Solution918();
        int[] nums = new int[]{-3, -2, -3};

        System.out.println(s.maxSubarraySumCircular(nums));
    }


}
