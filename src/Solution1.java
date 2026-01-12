import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, List<Integer>> num2idx = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int key = nums[i];
//            num2idx.computeIfAbsent(key, k -> new ArrayList<>())
//                    .add(i);
//        }
//
//        for (int key : num2idx.keySet()) {
//            int residualKey = target - key;
//            if (num2idx.containsKey(residualKey)) {
//                int a = num2idx.get(key).get(0);
//                num2idx.get(key).remove(0);
//                int b = num2idx.get(residualKey).get(0);
//
//                return new int[]{a, b};
//            }
//        }
//
//
//        return new int[]{0, 0};
//    }

    public int[] twoSum(int[] nums, int target) {
        // HashMap to store number value as key and its index as value
        // Buffer the numbers already seen
        Map<Integer, Integer> numberToIndexMap = new HashMap<>();

        // Iterate through the array
        for (int i = 0; ; ++i) {
            int currentNumber = nums[i];
            int complement = target - currentNumber;

            // Check if the complement exists in the map
            if (numberToIndexMap.containsKey(complement)) {
                // Found the pair that sums to target
                // Return the indices: [index of complement, current index]
                return new int[] {numberToIndexMap.get(complement), i};
            }

            // Store current number and its index in the map for future lookups
            numberToIndexMap.put(currentNumber, i);
        }
    }


    public static void main(String[] args) {
        Solution1 s = new Solution1();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] ans1 = s.twoSum(nums1, target1);
        System.out.println(ans1[0] + "," + ans1[1]);

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] ans2 = s.twoSum(nums2, target2);
        System.out.println(ans2[0] + "," + ans2[1]);

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] ans3 = s.twoSum(nums3, target3);
        System.out.println(ans3[0] + "," + ans3[1]);
    }

}
