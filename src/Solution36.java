import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int[] hash = new int[10];

        // row
        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {
                char c = board[row][col];
                if (c == '.') continue;

                if (hash[c - '0'] == 1) {
                    return false;
                } else {
                    hash[c - '0'] = 1;
                }
            }

            Arrays.fill(hash, 0);
        }

        // col
        for (int col = 0; col < n; col++) {

            for (int row = 0; row < n; row++) {
                char c = board[row][col];
                if (c == '.') continue;

                if (hash[c - '0'] == 1) {
                    return false;
                } else {
                    hash[c - '0'] = 1;
                }
            }

            Arrays.fill(hash, 0);
        }


        // box

        for (int originRow = 0; originRow < 9; originRow += 3) {
            for (int originCol = 0; originCol < 9; originCol += 3) {
                for (int i = 0; i < 9; i++) {
                    int row = i / 3 + originRow;
                    int col = i % 3 + originCol;

                    char c = board[row][col];
                    if (c == '.') continue;


                    if (hash[c - '0'] == 1) {
                        return false;
                    } else {
                        hash[c - '0'] = 1;
                    }


                }

                Arrays.fill(hash, 0);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution36 s = new Solution36();

        char[][] valid = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] invalidRowDup = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '5'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] invalidBoxDup = new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        System.out.println("valid -> " + s.isValidSudoku(valid));               // expected: true
        System.out.println("invalidRowDup -> " + s.isValidSudoku(invalidRowDup)); // expected: false
        System.out.println("invalidBoxDup -> " + s.isValidSudoku(invalidBoxDup)); // expected: false
    }
}
