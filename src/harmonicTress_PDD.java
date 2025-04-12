public class harmonicTress_PDD {
    private int helper(int harmonic, int[] trees) {
        int sum = 0;
        int[] table = new int[harmonic];
        for (int tree : trees) {
            sum += tree;
            table[sum % harmonic]++;
        }

        int result = 0;
        for (int i = 0; i < harmonic; i++) {
            result += (int) (table[i] * (table[i] - 1) * 0.5);
        }

        return result;
    }
}
