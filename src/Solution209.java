import java.awt.image.renderable.RenderableImage;

public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        while (right < nums.length) {

            sum += nums[right];
            right++;
            // While
            // If `sum >= target` shrink the window, until the condition doesn't meet anymore.
            while (sum >= target) {
                minLength = Math.min(minLength, right - left);
                sum -= nums[left++];
            }


        }

        return minLength;
    }
//
//    public int minSubArrayLen(int target, int[] nums) {
//        int n = nums.length;
//        int left = 0;
//        int right = 0;
//        long sum = 0;                // 用 long 更稳
//        int ans = Integer.MAX_VALUE;
//
//        while (right < n) {
//            sum += nums[right++];
//
//            while (sum >= target) {
//                ans = Math.min(ans, right - left);
//                sum -= nums[left];
//                left++;
//            }
//        }
//
//        return ans == Integer.MAX_VALUE ? 0 : ans;
//    }

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
//    public int minSubArrayLen(int target, int[] nums) {
//        int left = 0;
//        int sum = 0;
//        int minLen = Integer.MAX_VALUE;
//
//        for (int right = 0; right < nums.length; right++) {
//            sum += nums[right];
//
//            if (sum > target) {
//                minLen = Math.min(minLen, right - left + 1);
//                sum -= nums[left];
//                left++;
//            }
//
//        }
//
//        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
