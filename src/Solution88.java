import java.util.Arrays;

class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // start from the back
        int i = m - 1, j = n - 1;
        for (int k = nums1.length - 1; k >= 0; --k) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m = 0;
        int n = 1;

        solution88.merge(nums1, m, nums2, n);

        System.out.printf(Arrays.toString(nums1));

    }

}