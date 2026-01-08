
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int last = nums[0], k = 1;      // maintain the last one element and the idx of target position
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != last) {
                nums[k++] = nums[i];
                last = nums[i];
            }
        }
        return k;
    }


    public static void main(String[] args) {
        Solution26 s = new Solution26();
        int[][] tests = {
                {1, 1, 2},
                {0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
                {1},
                {2, 2}
        };

        for (int[] t : tests) {
            int[] nums = java.util.Arrays.copyOf(t, t.length);
            int k = s.removeDuplicates(nums);
            System.out.println("input: " + java.util.Arrays.toString(t));
            System.out.println("k = " + k + ", result = " + java.util.Arrays.toString(java.util.Arrays.copyOf(nums, k)));
            System.out.println();
        }
    }
}
