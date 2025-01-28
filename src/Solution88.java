import java.util.Arrays;

class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Create a copy of nums1's first m elements
        // Directly make modification on nums1
        int[] nums1Copy = Arrays.copyOf(nums1, m);

        int i = 0, j = 0, k = 0;

        // Merge nums1Copy and nums2 into nums1
        while (i < m && j < n) {
            if (nums1Copy[i] < nums2[j]) {
                nums1[k++] = nums1Copy[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }

        // Copy remaining elements of nums1Copy (if any)
        while (i < m) {
            nums1[k++] = nums1Copy[i++];
        }

        // Copy remaining elements of nums2 (if any)
        while (j < n) {
            nums1[k++] = nums2[j++];
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