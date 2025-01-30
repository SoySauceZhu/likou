public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            int concat = 0;
            for (int left = i; left < nums.length; left++) {
                if (nums[left] == nums[i]) {
                    concat++;
                }
            }

            if (concat == 1) {
                nums[j++] = nums[i];
            }

            if (concat >= 2) {
                nums[j++] = nums[i];
                nums[j++] = nums[i];
            }

            i += concat - 1;
        }

        return j;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        Solution80 solution80 = new Solution80();
        int a = solution80.removeDuplicates(nums);
        System.out.println(a);
    }
}
