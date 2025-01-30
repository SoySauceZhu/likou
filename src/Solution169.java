public class Solution169 {
    public int majorityElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            int n = 0;

            for (int start = i; start < nums.length; start++) {
                if (nums[start] == nums[i]) {
                    n++;
                }
            }

            if (n > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }


    private void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;

            while (j > 0 && nums[j - 1] > nums[j]) {
                int a = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = a;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 9, 9, 10};
        Solution169 solution169 = new Solution169();
        System.out.println(solution169.majorityElement(nums));
    }
}
