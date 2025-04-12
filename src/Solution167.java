public class Solution167 {
//    public int[] twoSum(int[] numbers, int target) {
//        int left, right;
//
//        for (left = 0; left < numbers.length - 1; left++) {
//            for (right = left + 1; right < numbers.length; right++) {
//                if (numbers[left] + numbers[right] == target) {
//                    return new int[]{left + 1, right + 1};
//                }
//            }
//        }
//
//        return null;
//    }


    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                // LeetCode expects 1‑indexed answers
                return new int[]{left + 1, right + 1};
            }

            /*
            If their sum is too low, you need a bigger number → move the left pointer right.

            If their sum is too high, you need a smaller number → move the right pointer left.
             */

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        // Problem guarantees exactly one solution, so this won’t happen
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        Solution167 solution = new Solution167();
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(numbers1, target1);
        System.out.println("Result 1: [" + result1[0] + ", " + result1[1] + "]");

        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(numbers2, target2);
        System.out.println("Result 2: [" + result2[0] + ", " + result2[1] + "]");

        int[] numbers3 = {-1, 0};
        int target3 = -1;
        int[] result3 = solution.twoSum(numbers3, target3);
        System.out.println("Result 3: [" + result3[0] + ", " + result3[1] + "]");
    }
}
