public class Solution169 {
    public int majorityElement(int[] nums) {
        // black and white GO piece

        int candidate = nums[0];
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            if (n == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 9, 9, 10};
        Solution169 solution169 = new Solution169();
        System.out.println(solution169.majorityElement(nums));
    }
}
