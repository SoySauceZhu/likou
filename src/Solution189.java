public class Solution189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        int[] buffer = new int[k];
        System.arraycopy(nums, nums.length - k, buffer, 0, k);


        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        System.arraycopy(buffer, 0, nums, 0, k);

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Solution189 solution189 = new Solution189();
        solution189.rotate(nums, 3);
    }
}
