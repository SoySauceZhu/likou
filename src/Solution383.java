public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];  // For 'a' to 'z'

        // Count letters in magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Subtract letters used in ransomNote
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) return false;  // Not enough of character c
        }

        return true;
    }

    public static void main(String[] args) {
        Solution383 solution = new Solution383();

        // Test cases
        System.out.println(solution.canConstruct("a", "b")); // Expected: false
        System.out.println(solution.canConstruct("aa", "ab")); // Expected: false
        System.out.println(solution.canConstruct("aa", "aab")); // Expected: true
    }

}
