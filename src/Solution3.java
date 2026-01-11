import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int[] hash = new int[128];
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < chars.length) {
            char c = chars[right++];

            while (hash[c] == 1) {
                hash[chars[left++]] = 0;
            }

            hash[c] = 1;
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;

    }


    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String a = "abcabcbb";
        String b = "dvdf";
        String c = "pwwkew";
        System.out.println(solution3.lengthOfLongestSubstring(a));
        System.out.println(solution3.lengthOfLongestSubstring(b));
        System.out.println(solution3.lengthOfLongestSubstring(c));
        System.out.println(solution3.lengthOfLongestSubstring(" "));
    }
}

//
//
//
//
//
//
//
//
//
//
//
//public int lengthOfLongestSubstring(String s) {
//    int maxLen = 0;
//    int left = 0;
//    int right;
//    Set<Integer> set = new HashSet<>();
//
//    for (right = 1; right < s.length()+ 1; right++) {
//        int suf = (int) s.charAt(right - 1);
//        while (set.contains(suf)) {
//            int pre = s.charAt(left);
//            left++;
//            set.remove(pre);
//        }
//        set.add(suf);
//        maxLen = Math.max(maxLen, right - left);
//    }
//    return maxLen;
//}
//

