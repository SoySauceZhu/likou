import java.util.*;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        helper(target);
        int max = Integer.MIN_VALUE;
        for (int i : candidates) {
            max = Math.max(max, i);
        }

        return result.stream().toList();
    }

    Set<List<Integer>> result = new HashSet<>();
    List<Integer> builder = new ArrayList<>();
    int[] candidates;

    private void helper(int target) {
        if (target < 0) return;
        if (target == 0) {
            List<Integer> sorted = new ArrayList<>(builder);
            result.add(sorted.stream().sorted().toList());
            return;
        }


        for (int candidate : candidates) {
            builder.add(candidate);
            helper(target - candidate);
            builder.remove(builder.size() - 1);
        }

    }

    public static void main(String[] args) {
            Solution39 s = new Solution39();

            int[] candidates1 = {2, 3, 6, 7};
            int target1 = 7;
            System.out.println("Input: candidates=[2,3,6,7], target=7");
            System.out.println("Output: " + s.combinationSum(candidates1, target1));

            Solution39 s2 = new Solution39();
            int[] candidates2 = {2, 3, 5};
            int target2 = 8;
            System.out.println("Input: candidates=[2,3,5], target=8");
            System.out.println("Output: " + s2.combinationSum(candidates2, target2));

            Solution39 s3 = new Solution39();
            int[] candidates3 = {2};
            int target3 = 1;
            System.out.println("Input: candidates=[2], target=1");
            System.out.println("Output: " + s3.combinationSum(candidates3, target3));

            Solution39 s4 = new Solution39();
            int[] candidates4 = {1};
            int target4 = 2;
            System.out.println("Input: candidates=[1], target=2");
            System.out.println("Output: " + s4.combinationSum(candidates4, target4));
        }
}
