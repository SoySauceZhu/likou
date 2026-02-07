import java.util.Arrays;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);

        int minHigh = points[0][1];
        int maxLow = points[0][0];
        int count = 1;

        for (int[] interval : points) {
            if (interval[0] > minHigh || interval[1] < maxLow) {
                count++;

                minHigh = interval[1];
                maxLow = interval[0];
            } else {
                minHigh = Math.min(minHigh, interval[1]);
                maxLow = Math.max(maxLow, interval[0]);
            }
        }


        return count;
    }
}
