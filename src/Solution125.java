public class Solution125 {
    public boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return palindromeHelper(clean);
    }

    private boolean palindromeHelper(String s) {
        if (s.length() <= 1) {
            return true;
        } else {
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                return palindromeHelper(s.substring(1, s.length() - 1));
            } else {
                return false;
            }
        }
    }


    public static void main(String[] args) {
        Solution125 solution = new Solution125();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(solution.isPalindrome("race a car")); // false
        System.out.println(solution.isPalindrome(" ")); // true
    }
}
