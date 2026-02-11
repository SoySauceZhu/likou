public class KnapsackProblem {

    /**
     * 0/1 背包问题的核心算法
     *
     * @param W       背包最大容量
     * @param weights 物品重量数组
     * @param values  物品价值数组
     * @return 最大价值
     */
    public int solveKnapsack(int W, int[] weights, int[] values) {
        int n = weights.length;
        // 请在此处实现你的逻辑
        // 提示：可以使用二维数组 dp[n+1][W+1]
        // 或者优化为一维数组 dp[W+1]


        // 2D dp
        int[][] maxValueWithFirstIthBag = new int[n + 1][W + 1];

        for (int itemIdx = 1; itemIdx < n + 1; itemIdx++) {
            // Select the item

            for (int w = 1; w < W + 1; w++) {
                // The item can't fit in even only one item[idx]
                if (w < weights[itemIdx - 1]) {
                    maxValueWithFirstIthBag[itemIdx][w] = maxValueWithFirstIthBag[itemIdx - 1][w];
                    continue;
                }

                // Carry the weight, add the value
                int carryValue = maxValueWithFirstIthBag[itemIdx - 1][w - weights[itemIdx - 1]] + values[itemIdx - 1];


                // Not carry the weight, no value added
                int notCarryValue = maxValueWithFirstIthBag[itemIdx - 1][w];

                maxValueWithFirstIthBag[itemIdx][w] = Math.max(carryValue, notCarryValue);

            }
        }

        return maxValueWithFirstIthBag[n][W];

    }

    /* WRONG: this is a complete knapsack problem, outer loop is the volume of bag,
                                                    inner loop iterate through the last item weight

    public int solve2(int W, int[] weights, int[] values) {
        int[] dp = new int[W + 1];

        for (int i = 1; i < W + 1; i++) {
            int maxValue = 0;
            for (int w = 0; w < weights.length; w++) {
                if (i - weights[w] >= 0) {
                    int carry = dp[i - weights[w]] + values[w];
                    int noCarry = dp[i - 1];
                    maxValue = Math.max(maxValue, Math.max(carry, noCarry));
                }
            }
            dp[i] = maxValue;
        }
        return dp[W];
    }
     */


    /*
        0/1 knapsack problem
     */
    public int solve2(int W, int[] weights, int[] values) {
        int[] dp = new int[W + 1];

        for (int w = 0; w < weights.length; w++) {
            for (int i = W; i >= weights[w]; i--) {
                // r-value dp[i] is the old value: interpreted as
                // "while not choosing weight[w] as last item in sack, the max value of the 'i' volume sack"
                dp[i] = Math.max(dp[i], dp[i - weights[w]]+values[w]);
            }
        }
        return dp[W];
    }


    // --- 测试入口 ---
    public static void main(String[] args) {
        KnapsackProblem solution = new KnapsackProblem();

        // 测试用例 1
        int W1 = 5;
        int[] weights1 = {1, 2, 3};
        int[] values1 = {6, 10, 12};
        // 预期输出: 22 (选择重量 2 和 3 的物品)
        System.out.println("Test Case 1: " + (solution.solve2(W1, weights1, values1) == 22 ? "Passed" : "Failed"));

        // 测试用例 2
        int W2 = 10;
        int[] weights2 = {2, 3, 5, 7};
        int[] values2 = {1, 5, 2, 4};
        // 预期输出: 9 (选择重量 3 和 5 的物品)
        System.out.println("Test Case 2: " + (solution.solveKnapsack(W2, weights2, values2) == 9 ? "Passed" : "Failed"));
    }
}