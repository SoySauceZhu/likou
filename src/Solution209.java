public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 1; right <= nums.length; right++) {
            sum += nums[right - 1];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left);
                sum -= nums[left];
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
