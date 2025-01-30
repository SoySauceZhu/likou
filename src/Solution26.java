
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 2, 2, 2, 3, 4, 5, 5, 6, 7, 8};
        Solution26 solution26 = new Solution26();
        System.out.println(solution26.removeDuplicates(a));
    }
}
