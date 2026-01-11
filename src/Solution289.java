public class Solution289 {
    public void gameOfLife(int[][] board) {
        int[][] staged = new int[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                staged[row][col] = kernel(board, row, col);

            }

        }

        for (int i = 0; i < board.length; i++) {
            System.arraycopy(staged[i], 0, board[i], 0, board[0].length);
        }

    }

    private int kernel(int[][] board, int row, int col) {
        // dx dy: offset matrix
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int rowNum = board.length;
        int colNum = board[0].length;


        int n = 0;

        for (int i = 0; i < 8; i++) {
            int x = col + dx[i];
            int y = row + dy[i];

            if (!(x >= colNum || x < 0 || y >= rowNum || y < 0)) {
                n += board[y][x];
            }
        }


        if (board[row][col] == 1) {
            if (n < 2 || n > 3) {
                return 0;
            }
        } else {
            if (n == 3) {
                return 1;
            }
        }

        return board[row][col];
    }

    public static void main(String[] args) {
            Solution289 s = new Solution289();

            int[][] board1 = {
                    {0, 1, 0},
                    {0, 0, 1},
                    {1, 1, 1},
                    {0, 0, 0}
            };
            s.gameOfLife(board1);
            printBoard(board1);

            int[][] board2 = {
                    {1, 1},
                    {1, 0}
            };
            s.gameOfLife(board2);
            printBoard(board2);

            int[][] board3 = {
                    {1}
            };
            s.gameOfLife(board3);
            printBoard(board3);
        }

        private static void printBoard(int[][] board) {
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[0].length; c++) {
                    if (c > 0) System.out.print(" ");
                    System.out.print(board[r][c]);
                }
                System.out.println();
            }
            System.out.println();
        }
}
