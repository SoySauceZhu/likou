public class Solution300 {
    public int lengthOfLIS(int[] nums) {

        int[] seqLenEndWithIdx = new int[nums.length + 1];

        int globalMax = 0;

        for (int n = 0; n < nums.length; n++) {
            int p = nums[n];
            int maxLen = 1;
            for (int i = 0; i < n; i++) {
                if (p > nums[i]) {
                    maxLen = Math.max(maxLen, seqLenEndWithIdx[i] + 1);
                }
            }
            seqLenEndWithIdx[n] = maxLen;
            globalMax = Math.max(globalMax, maxLen);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        Solution300 s = new Solution300();

        int[][] tests = new int[][]{
                {10, 9, 2, 5, 3, 7, 101, 18}, // expected 4
                {0, 1, 0, 3, 2, 3},           // expected 4
                {7, 7, 7, 7, 7, 7, 7},        // expected 1
                {1},                          // expected 1
                {1, 2, 3, 4, 5},              // expected 5
                {5, 4, 3, 2, 1}               // expected 1
        };

        for (int i = 0; i < tests.length; i++) {
            int ans = s.lengthOfLIS(tests[i]);
            System.out.println("case " + (i + 1) + ": " + ans);
        }
    }
}
