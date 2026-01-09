public class Solution189 {
    public void rotate(int[] nums, int k) {
        // Triple reverse
        // Time O(2n)
        // Space O(1)
        int n = nums.length;
        if (n <= 1) return;

        k %= n;
        if (k == 0) return;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Solution189 solution189 = new Solution189();
        solution189.rotate(nums, 3);
        System.out.println(java.util.Arrays.toString(nums));
    }
}


//        k %= nums.length;
//
//        int[] buffer = new int[k];
//        System.arraycopy(nums, nums.length - k, buffer, 0, k);
//
//
//        for (int i = nums.length - 1; i >= k; i--) {
//            nums[i] = nums[i - k];
//        }
//
//        System.arraycopy(buffer, 0, nums, 0, k);