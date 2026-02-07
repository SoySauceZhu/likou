import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    private List<Integer> arrayBuilder;
    private List<List<Integer>> result;
    private int k, n;

    public List<List<Integer>> combine(int n, int k) {
        // k: # of numbers
        // n: range
        this.k = k;
        this.n = n;
        result = new ArrayList<>();

        arrayBuilder = new ArrayList<>();

        dfs(0, 1);
        return result;
    }

    private void dfs(int idx, int start) {
        if (idx >= k) {
            result.add(new ArrayList<>(arrayBuilder));
            return;
        }

        for (int i = start; i <= n; i++) {
            arrayBuilder.add(i);
            dfs(idx + 1, i + 1);
            arrayBuilder.remove(arrayBuilder.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution77 sol = new Solution77();

        int n = 4;
        int k = 2;

        List<List<Integer>> combos = sol.combine(n, k);
        System.out.println(combos);
    }

}
