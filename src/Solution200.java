
public class Solution200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    flood(grid, row, col);
                }
            }
        }
        return count;
    }

    private void flood(char[][] grid, int row, int col) {
        int[] dRow = new int[]{0, 0, 1, -1};
        int[] dCol = new int[]{1, -1, 0, 0};

        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            if (grid[row][col] == '1') {
                grid[row][col] = '0';

                for (int i = 0; i < 4; i++) {
                    flood(grid, row + dRow[i], col + dCol[i]);
                }

            }

        }
    }

    public static void main(String[] args) {
            Solution200 s = new Solution200();

            char[][] grid1 = {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '0', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}
            };
            System.out.println("Expected: 1, Actual: " + s.numIslands(copy(grid1)));

            char[][] grid2 = {
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}
            };
            System.out.println("Expected: 3, Actual: " + s.numIslands(copy(grid2)));

            char[][] grid3 = {
                    {'0', '0', '0'},
                    {'0', '0', '0'}
            };
            System.out.println("Expected: 0, Actual: " + s.numIslands(copy(grid3)));
        }

        private static char[][] copy(char[][] grid) {
            char[][] out = new char[grid.length][];
            for (int i = 0; i < grid.length; i++) {
                out[i] = grid[i].clone();
            }
            return out;
        }
}
