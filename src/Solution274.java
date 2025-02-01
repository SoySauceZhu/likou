public class Solution274 {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];

        for (int citation : citations) {
            for (int c = 0; c <= citation; c++) {
                if (c < count.length) {
                    count[c] += 1;
                }
            }
        }

        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] >= i) return i;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        Solution274 solution274 = new Solution274();
        System.out.println(solution274.hIndex(citations));
    }
}
