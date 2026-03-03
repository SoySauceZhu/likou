public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int s_ptr = 0;
        int t_ptr = 0;

        while (s_ptr < s.length() && t_ptr < t.length()) {
            if (s.charAt(s_ptr) == t.charAt(t_ptr)) {
                s_ptr++;
                t_ptr++;
            } else {
                t_ptr++;
            }

            if (s_ptr == s.length()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution392 sol = new Solution392();

        System.out.println(sol.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(sol.isSubsequence("axc", "ahbgdc")); // false
        System.out.println(sol.isSubsequence("", "ahbgdc"));    // true
        System.out.println(sol.isSubsequence("abc", ""));       // false
        System.out.println(sol.isSubsequence("aaaa", "aa"));    // false
        System.out.println(sol.isSubsequence("ace", "abcde"));  // true
    }
}
