public class Solution55 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int furthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > furthest) return false;
            furthest = Math.max(furthest, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        Solution55 solution55 = new Solution55();
        System.out.println(solution55.canJump(nums));
    }
}
