import java.util.HashMap;
import java.util.Map;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (!mapST.containsKey(sChar)) {
                mapST.put(sChar, tChar);
            } else {
                if (!mapST.get(sChar).equals(tChar)) {
                    return false;
                }
            }

            if (!mapTS.containsKey(tChar)) {
                mapTS.put(tChar, sChar);
            } else {
                if (!mapTS.get(tChar).equals(sChar)) {
                    return false;
                }
            }


        }
        return true;
    }

    public static void main(String[] args) {
        Solution205 solution = new Solution205();

        // Test cases
        System.out.println(solution.isIsomorphic("egg", "add")); // Expected: true
        System.out.println(solution.isIsomorphic("foo", "bar")); // Expected: false
        System.out.println(solution.isIsomorphic("paper", "title")); // Expected: true
        System.out.println(solution.isIsomorphic("ab", "aa")); // Expected: false
    }
}
