import java.util.Arrays;

public class Solution45 {
    public int jump(int[] nums) {
        // Greedy, Time O(n)


        /*
        When we must make a jump (when we reach the end of our current jump's range),
        we should always jump here or somewhere before
        to allow us to reach the farthest in the next jump.
         */
        int n = nums.length;
        if (n <= 1) return 0;

        int step = 0;
        int maxRangeWithinStep = 0;
        int maxRangeWithinStep_plus1 = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxRangeWithinStep_plus1 = Math.max(maxRangeWithinStep_plus1, i + nums[i]);

            if (i == maxRangeWithinStep) {
                // ok, we need to choose somewhere before to jump,
                // and update maxRangeWithinStep by maxRangeWithinStep_plus1
                step++;
                maxRangeWithinStep = maxRangeWithinStep_plus1;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        Solution45 solution45 = new Solution45();
        System.out.println(solution45.jump(nums));
    }
}


// Furthest = max( furthest so far,
//    //                  where you can reach if jump at this position)
//
//    // There must be a jump between (i, furthest),
//    //                          and after that jump, furthest will be updated
//
//    // You should find the position between (i, furthest),
//    //              at which j+nums[j] is the largest among all (i, furthest)
//    //              but we only care where can we reach at furthest
//
//    public int jump(int[] nums) {
//        int jumpNum = 0;
//        int furthest = 0;
//        int furthestCandidate = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            furthestCandidate = Math.max(furthestCandidate, i + nums[i]);
//
//           if (i >= furthest && i < nums.length - 1) {
//               jumpNum++;
//               furthest = furthestCandidate;
//           }
//        }
//
//        return jumpNum;
//    }