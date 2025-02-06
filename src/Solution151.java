public class Solution151 {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\W+");

        int l = 0, r = words.length - 1;
        while (l < r) {
            String temp = words[l];
            words[l] = words[r];
            words[r] = temp;
            l++;
            r--;
        }

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        String s = "hello world to you";
        System.out.println(solution151.reverseWords(s));
    }
}
