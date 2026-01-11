import java.util.ArrayList;
import java.util.List;

public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        int n = (Math.min(matrix.length, matrix[0].length) + 1) / 2;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int deltaRow = matrix.length - 2 * i;
            int deltaCol = matrix[0].length - 2 * i;
            list.addAll(rectangular(matrix, i, i, deltaRow, deltaCol));
        }

        return list;
    }

    private List<Integer> rectangular(int[][] matrix, int originRow, int originCol, int deltaRow, int deltaCol) {
        /*
            Like pealing an onion, remove the most outer layer
         */


        List<Integer> list = new ArrayList<>();
        for (int c = 0; c < deltaCol; c++) {
            list.add(matrix[originRow][originCol + c]);
        }

        for (int r = 1; r < deltaRow; r++) {
            list.add(matrix[originRow + r][originCol + deltaCol - 1]);
        }

        // Deal non n*n matrix
        if (deltaRow == 1) return list;
        for (int c = deltaCol - 2; c >= 0; c--) {
            list.add(matrix[originRow + deltaRow - 1][originCol + c]);
        }

        if (deltaCol == 1) return  list;
        for (int r = deltaRow - 2; r > 0; r--) {
            list.add(matrix[originRow + r][originCol]);
        }

        return list;

    }

    public static void main(String[] args) {
        Solution54 sol = new Solution54();

        int[][] m1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(sol.spiralOrder(m1)); // [1, 2, 3, 6, 9, 8, 7, 4, 5]

        int[][] m2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(sol.spiralOrder(m2)); // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

        int[][] m3 = {{1}};
        System.out.println(sol.spiralOrder(m3)); // [1]
    }

}
