import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        // Travers two times: first set flags, second commit update
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        boolean[] rowFlags = new boolean[rowNum];
        boolean[] colFlags = new boolean[colNum];
        Arrays.fill(rowFlags, false);
        Arrays.fill(colFlags, false);

        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (matrix[row][col] == 0) {
                    rowFlags[row] = true;
                    break;
                }
            }
        }


        for (int col = 0; col < colNum; col++) {
            for (int row = 0; row < rowNum; row++) {
                if (matrix[row][col] == 0) {
                    colFlags[col] = true;
                    break;
                }
            }
        }

        for (int row = 0; row < rowNum; row++) {
            if (rowFlags[row]) {
                for (int col = 0; col < colNum; col++) {
                    matrix[row][col] = 0;
                }
            }
        }


        for (int col = 0; col < colNum; col++) {
            if (colFlags[col]) {
                for (int row = 0; row < rowNum; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
            Solution73 s = new Solution73();

            int[][] m1 = {
                    {1, 1, 1},
                    {1, 0, 1},
                    {1, 1, 1}
            };
            s.setZeroes(m1);
            System.out.println("m1=" + Arrays.deepToString(m1) + " expected=[[1, 0, 1], [0, 0, 0], [1, 0, 1]]");

            int[][] m2 = {
                    {0, 1, 2, 0},
                    {3, 4, 5, 2},
                    {1, 3, 1, 5}
            };
            s.setZeroes(m2);
            System.out.println("m2=" + Arrays.deepToString(m2) + " expected=[[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]");

            int[][] m3 = {
                    {1, 2},
                    {3, 4}
            };
            s.setZeroes(m3);
            System.out.println("m3=" + Arrays.deepToString(m3) + " expected=[[1, 2], [3, 4]]");

            int[][] m4 = {
                    {0}
            };
            s.setZeroes(m4);
            System.out.println("m4=" + Arrays.deepToString(m4) + " expected=[[0]]");

            int[][] m5 = {
                    {1, 0, 3}
            };
            s.setZeroes(m5);
            System.out.println("m5=" + Arrays.deepToString(m5) + " expected=[[0, 0, 0]]");

            int[][] m6 = {
                    {1},
                    {0},
                    {3}
            };
            s.setZeroes(m6);
            System.out.println("m6=" + Arrays.deepToString(m6) + " expected=[[0], [0], [0]]");
        }
}
