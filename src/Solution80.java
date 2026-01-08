public class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        //Always keep the first two elements.
        //
        //For each next element nums[i], compare it with nums[k-2].
        //
        //If they differ, write nums[i] to nums[k].

        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {   // Here, nums[0]~nums[k] maintain the already saved nums. i.e. [1,2,2,3,4,4]
                                            // If nums[i] == nums[k-1] and nums[k-2], then not good,
                                            // You should not append nums[k] by nums[i] anymore.
                                            // Otherwise (nums[i] != nums[k-1] or nums[k-2]), you should append nums[i] to nums[k] (for once), whatever nums[i] is (same or bigger).
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        Solution80 solution80 = new Solution80();
        int a = solution80.removeDuplicates(nums);
        System.out.println(a);
        System.out.println(java.util.Arrays.toString(nums));
    }
}
