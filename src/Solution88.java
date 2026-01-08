import java.util.Arrays;

class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // start from the back
        // copy from nums1[i] or nums[j]

        // if m > n, when j runs out, stop
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
            --k;
        }

        // if m < n, when i runs out, copy remaining nums2 to nums1
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] nums1 = {0};
        int[] nums2 = {1};

        solution88.merge(nums1, 0, nums2, 1);

        System.out.printf(Arrays.toString(nums1));

    }

}