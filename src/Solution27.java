public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j : nums) {
            if (j != val) {
                nums[i++] = j;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution27 s = new Solution27();

        int[] a1 = {3, 2, 2, 3};
        int k1 = s.removeElement(a1, 3);
        System.out.println("k1 = " + k1 + ", nums = " + java.util.Arrays.toString(java.util.Arrays.copyOf(a1, k1)));

        int[] a2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int k2 = s.removeElement(a2, 2);
        System.out.println("k2 = " + k2 + ", nums = " + java.util.Arrays.toString(java.util.Arrays.copyOf(a2, k2)));
    }
}
