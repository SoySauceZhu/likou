import java.util.*;
import java.util.stream.Collectors;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int last_i, last_left, last_right;

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));
                    left++;
                    right--;

                    // Skip duplicate values for the second element
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate values for the third element
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return result;

    }


    public static void main(String[] args) {
        Solution15 s = new Solution15();
        int[] nums = new int[]{-4, -1, -1, 0, 1, 2};
        List<List<Integer>> res = s.threeSum(nums);
        System.out.println("Input: " + java.util.Arrays.toString(nums));
        System.out.println("Triplets summing to zero:");
        for (List<Integer> triplet : res) {
            System.out.println(triplet);
        }
    }
}

