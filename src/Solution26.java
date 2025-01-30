
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

    private void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;

            while (j > 0 && nums[j - 1] > nums[j]) {
                int a = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = a;
                j--;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 2, 2, 2, 3, 4, 5, 5, 6, 7, 8};
        Solution26 solution26 = new Solution26();
        int[] b = new int[]{9,5,2,3,6,8,1,0,7,4};
        solution26.insertSort(b);
    }
}
