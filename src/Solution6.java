public class Solution6 {
    public String convert(String s, int numRows) {
        // Boring question

        if (numRows == 0) return s;
        int period = numRows * 2 - 2;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < chars.length; j = j + period) {
                    sb.append(chars[j]);
                }
            } else {
                for (int j = i; j < chars.length; j = j + period) {
                    sb.append(chars[j]);

                    int next = j + period - 2 * i;
                    if (next < chars.length ) {
                        sb.append(chars[next]);
                    }
                }

            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution6 sol = new Solution6();
        test(sol, "PAYPALISHIRING", 3, "PAHNAPLSIIGYIR");
        test(sol, "PAYPALISHIRING", 4, "PINALSIGYAHRPI");
        test(sol, "ABCDE", 2, "ACEBD");
    }

    private static void test(Solution6 sol, String s, int numRows, String expected) {
        String out = sol.convert(s, numRows);
        System.out.printf("s=%s, numRows=%d -> out=%s, expected=%s, %s%n",
                s, numRows, out, expected, out.equals(expected) ? "PASS" : "FAIL");
    }
}
