import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution22 {
    private List<String> ans = new ArrayList<>();
    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0, "");
        return ans;
    }

    private void dfs(int open, int close, String s) {
        if (open > n || close > n || close > open) return;
        if (open == n && close == n) {
            ans.add(s);
        }

        dfs(open + 1, close, s + "(");
        dfs(open, close + 1, s + ")");
    }




    public static void main(String[] args) {
        Solution22 sol = new Solution22();

        int n = 3;
        List<String> res = sol.generateParenthesis(n);

        for (String s : res) {
            System.out.println(s);
        }
    }

}
