import java.util.*;

class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }

        int max = 0;

        // startpoint, length
        Map<Integer, Integer> intervals = new HashMap<>();

        for (int num : nums) {
            int i = 0;
            while (set.contains(num + i)) {
                set.remove(num + i);
                i++;
            }

            int currLen = i + intervals.getOrDefault(num + i, 0);
            intervals.put(num, currLen);

            max = Math.max(max, currLen);
        }

        return max;
    }

public static void main(String[] args) {
        Solution128 sol = new Solution128();

        int[][] tests = new int[][]{
                {},                         // 0
                {100, 4, 200, 1, 3, 2},      // 4
                {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, // 9
                {1, 2, 0, 1},                // 3
                {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6} // 7
        };
        int[] expected = new int[]{0, 4, 9, 3, 7};

        for (int t = 0; t < tests.length; t++) {
            int actual = sol.longestConsecutive(tests[t]);
            System.out.println("test " + t + ": expected=" + expected[t] + ", actual=" + actual);
        }
    }
}