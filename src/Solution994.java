import java.util.ArrayDeque;
import java.util.Queue;

public class Solution994 {

    public int orangesRotting(int[][] grid) {
        /*
            use a Queue to store rotten position
            use an int count to store fresh fruit count.

            queue is cleared: no rotten anymore
         */

        int[] dX = {-1, 0, 0, 1};
        int[] dY = {0, 1, -1, 0};
        Queue<int[]> queue = new ArrayDeque<>();
        int tick = 0;
        int freshCount = 0;

//        int numToRotBuffer = 0;
//        int leftRottenNum = 0;
//
        // Initialize the queue
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                }

                if (grid[row][col] == 1) {
                    freshCount++;
                }
            }
        }
//
//        while (!queue.isEmpty()) {
//            int row = queue.peek()[0];
//            int col = queue.poll()[1];
//

//
//
//            for (int i = 0; i < 4; i++) {
//                int r = row + dY[i];
//                int c = col + dX[i];
//
//                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
//                    if (grid[r][c] == 1) {
//                        grid[r][c] = 2;
//                        queue.offer(new int[]{r, c});
//                        numToRotBuffer++;
//                    }
//                }
//            }
//
//            leftRottenNum--;
//            if (leftRottenNum == 0) {
//                tick++;
//                leftRottenNum = numToRotBuffer;
//                numToRotBuffer = 0;
//            }
//        }
//
//        return tick;

        while (!queue.isEmpty() && freshCount > 0) {
            tick++;
            /*
                马后炮：你这里要在一个tick里处理一组橘子。
                        只需要在while里再套一个 for i in range(queue.size)。
                        按照“还没添加新橘子”时的queue长度遍历。

                        可以倒着i--，也可以存一个临时变量
             */
            for (int i = queue.size(); i > 0; i--) {
                int row = queue.peek()[0];
                int col = queue.poll()[1];

                for (int d = 0; d < 4; d++) {
                    int r = row + dY[d];
                    int c = col + dX[d];

                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
                        if (grid[r][c] == 1) {
                            grid[r][c] = 2;
                            queue.offer(new int[]{r, c});
                            freshCount--;
                        }
                    }

                }
            }
        }

        return freshCount == 0 ? tick: -1;
    }

    public static void main(String[] args) {
        Solution994 s = new Solution994();

        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 1},
                {0, 1, 2}
        };
        System.out.println(s.orangesRotting(grid1)); // expected: 4

        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println(s.orangesRotting(grid2)); // expected: -1

        int[][] grid3 = {
                {0, 2}
        };
        System.out.println(s.orangesRotting(grid3)); // expected: 0
    }
}
