import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        int right;
        Set<Integer> set = new HashSet<>();

        for (right = 1; right < s.length()+ 1; right++) {
            int suf = (int) s.charAt(right - 1);
            while (set.contains(suf)) {
                int pre = s.charAt(left);
                left++;
                set.remove(pre);
            }
            set.add(suf);
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String a = "abcabcbb";
        String b = "bbbbb";
        String c = "pwwkew";
        System.out.println(solution3.lengthOfLongestSubstring(a));
        System.out.println(solution3.lengthOfLongestSubstring(b));
        System.out.println(solution3.lengthOfLongestSubstring(c));
        System.out.println(solution3.lengthOfLongestSubstring(" "));
    }
}
