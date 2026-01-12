import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution290 {

    public boolean wordPattern(String s, String pattern) {
        Map<String, Character> pattern2s = new HashMap<>();
        Map<Character, String> s2pattern = new HashMap<>();

        String[] patternArray = pattern.split(" ");

        if (patternArray.length != s.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            String patternString = patternArray[i];
            char sChar = s.charAt(i);

            if (s2pattern.containsKey(sChar) && !Objects.equals(s2pattern.get(sChar), patternString)) {
                return false;
            } else {
                s2pattern.put(sChar, patternString);
            }

            if (pattern2s.containsKey(patternString) && pattern2s.get(patternString) != sChar) {
                return false;
            } else {
                pattern2s.put(patternString, sChar);
            }

        }

        return true;
    }

    public static void main(String[] args) {
        Solution290 solution = new Solution290();

        // Test case 1
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        System.out.println(solution.wordPattern(pattern1, s1)); // Expected: true

        // Test case 2
        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        System.out.println(solution.wordPattern(pattern2, s2)); // Expected: false

        // Test case 3
        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";
        System.out.println(solution.wordPattern(pattern3, s3)); // Expected: false

        // Test case 4
        String pattern4 = "abba";
        String s4 = "dog dog dog dog";
        System.out.println(solution.wordPattern(pattern4, s4)); // Expected: false
    }

}


//
//
//
//
//
//
//
//public boolean wordPattern(String pattern, String s) {
//    String[] words = s.split(" ");
//    String[] patterns = pattern.split("");
//    if (patterns.length != words.length) return false;
//    Map<String, Integer> wordMap = new HashMap<>();
//    Map<String, Integer> patternMap = new HashMap<>();
//
//    int n = 0;
//    int m = 0;
//
//    for (int i = 0; i < pattern.length(); i++) {
//        String word = words[i];
//        String pat = patterns[i];
//        if (!wordMap.containsKey(word)) {
//            wordMap.put(word, n++);
//        }
//        if (!patternMap.containsKey(pat)) {
//            patternMap.put(pat, m++);
//        }
//
//        if (!Objects.equals(patternMap.get(pat), wordMap.get(word))) return false;
//    }
//    return true;
//}