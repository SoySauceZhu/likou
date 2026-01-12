import java.util.HashMap;
import java.util.Map;

public class Solution242 {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);


            frequency.put(c, frequency.getOrDefault(c, 0) - 1);
        }

        for (int freq : frequency.values()) {
            if (freq != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution242 sol = new Solution242();

//            System.out.println(sol.isAnagram("anagram", "nagaram")); // true
//            System.out.println(sol.isAnagram("rat", "car")); // false
//            System.out.println(sol.isAnagram("", "")); // true
        System.out.println(sol.isAnagram("ab", "a")); // true
        System.out.println(sol.isAnagram("a", "b")); // false
    }

}
