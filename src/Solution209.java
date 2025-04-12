public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            if (sum > target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }

        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main(String[] args) {
        Solution209 solution = new Solution209();

        // Test case 1
        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        System.out.println("Test case 1: " + solution.minSubArrayLen(target1, nums1)); // Expected output: 2

        // Test case 2
        int target2 = 4;
        int[] nums2 = {1, 4, 4};
        System.out.println("Test case 2: " + solution.minSubArrayLen(target2, nums2)); // Expected output: 1

        // Test case 3
        int target3 = 11;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Test case 3: " + solution.minSubArrayLen(target3, nums3)); // Expected output: 0
    }
}
