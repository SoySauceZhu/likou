public class Solution55 {
    public boolean canJump(int[] nums) {
        int canJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > canJump) {
                return false;
            }
            canJump = Math.max(canJump, nums[i] + i);
        }

        return canJump >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,0};
        Solution55 solution55 = new Solution55();
        System.out.println(solution55.canJump(nums));
    }
}


//    // For each iteration
//    // Furthest you can reach =
//    //          max( furthest you can reach so far,
//    //                  the position you reach if jump at this iteration)
//
//    public boolean canJump(int[] nums) {
//        if (nums == null || nums.length == 0) return false;
//
//        int furthest = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (i > furthest) return false;
//            furthest = Math.max(furthest, i + nums[i]);
//        }
//
//        return furthest >= nums.length - 1;
//    }
//
