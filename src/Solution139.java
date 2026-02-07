import java.util.*;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];     // is i's prefix breakable
        /*
        int lastBreakable = 0;          // if lastBreakable = ture
        // && string after lastBreakable is breakable
        */

        Deque<Integer> lastBreakableStack = new ArrayDeque<>();
        lastBreakableStack.push(0);
        dp[0] = false;

        for (int i = 1; i <= s.length(); i++) {
            for (int lastBreakable : lastBreakableStack) {
                String str = s.substring(lastBreakable, i);
                if (wordDict.contains(str)) {
                    dp[i] = true;
                    break;
                }
            }
            lastBreakableStack.push(i);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Solution139 sol = new Solution139();

        System.out.println(sol.wordBreak("aaaaaaa", List.of("aaaa", "aaa"))); // expected: true
        System.out.println(sol.wordBreak("leetcode", List.of("leet", "code"))); // expected: true
        System.out.println(sol.wordBreak("applepenapple", List.of("apple", "pen"))); // expected: true
        System.out.println(sol.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // expected: false
    }
}
