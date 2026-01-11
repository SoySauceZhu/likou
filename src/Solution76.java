import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution76 {
    public String minWindow(String s, String t) {
        /*
            Expand the window by moving the right pointer to include more characters until we have all characters from t
            Once we have a valid window, contract it by moving the left pointer to make it as small as possible while still containing all required characters
            Record the minimum valid window found so far
         */
        int globalStart = 0;
        int globalEnd = s.length() + 1;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0, right = 0;

        /*
            This while loop condition is a bit weird,
            Because I only use one while (no inner while for left pointer, but a continue instead)
            So I can't put right++ at the beginner, otherwise the continue won't work

            If I use another while, I can put righ++ at the beginning, and we can use `right < s.length()`
         */
        while (right <= s.length() && left <= right) {
            boolean meet = true;
            // check window status
            for (char c : map.keySet()) {
                if (!windowMap.containsKey(c) || windowMap.get(c) < map.get(c)) {
                    meet = false;
                }
            }


            // if contains enough `t`
            // shrink left as possible to test if the window can be smaller
            if (meet) {
                // update global record
                if (right - left < globalEnd - globalStart) {
                    globalEnd = right;
                    globalStart = left;
                }

                // update boundary
                char c = s.charAt(left);
                if (windowMap.containsKey(c) && windowMap.get(c) > 0) {
                    windowMap.put(c, windowMap.get(c) - 1);
                }
                left++;
                continue;
            }


            // if not enough `t`, expand right boundary
            if (right < s.length()) {
                char c = s.charAt(right);
                if (windowMap.containsKey(c)) {
                    windowMap.put(c, windowMap.get(c) + 1);
                } else {
                    windowMap.put(c, 1);
                }
            }
            right++;
        }

        return globalEnd <= s.length() ? s.substring(globalStart, globalEnd) : "";

    }


    public static void main(String[] args) {
        Solution76 sol = new Solution76();

        // LeetCode 76 examples
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC")); // expected: BANC
        System.out.println(sol.minWindow("a", "a"));              // expected: a
        System.out.println(sol.minWindow("a", "aa"));             // expected: (empty)

        // Additional sanity checks
        System.out.println(sol.minWindow("", "A"));               // expected: (empty)
        System.out.println(sol.minWindow("A", ""));               // expected: (empty) or A depending on definition
        System.out.println(sol.minWindow("ab", "b"));             // expected: b
    }
}
