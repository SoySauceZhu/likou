public class Solution5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0 || n == 1) return s;
        int[] ans = new int[]{0, 0};
        boolean[][] dp = new boolean[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            dp[i][i + 1] = true;
            ans[0] = i;
            ans[1] = i + 1;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 2] = true;
                ans[0] = i;
                ans[1] = i + 2;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j - 1) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }

            }
        }

        return s.substring(ans[0], ans[1]);
    }

    public static void main(String[] args) {
        String s = "babad";
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome(s));
    }

}
