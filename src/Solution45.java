public class Solution45 {
    // Furthest = max( furthest so far,
    //                  where you can reach if jump at this position)

    // There must be a jump between (i, furthest),
    //                          and after that jump, furthest will be updated

    // You should find the position between (i, furthest),
    //              at which j+nums[j] is the largest among all (i, furthest)
    //              but we only care where can we reach at furthest

    public int jump(int[] nums) {
        int jumpNum = 0;
        int furthest = 0;
        int furthestCandidate = 0;

        for (int i = 0; i < nums.length; i++) {
            furthestCandidate = Math.max(furthestCandidate, i + nums[i]);

           if (i >= furthest && i < nums.length - 1) {
               jumpNum++;
               furthest = furthestCandidate;
           }
        }

        return jumpNum;
    }

    public static void main(String[] args) {
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,1,3};
        Solution45 solution45 = new Solution45();
        System.out.println(solution45.jump(nums));
    }
}
