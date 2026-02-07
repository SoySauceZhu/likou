import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        if (newInterval.length == 0) return intervals;

        List<int[]> result = new ArrayList<>();
        boolean inserted = false;

        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0]) {
                if (!inserted) {
                    inserted = true;
                    result.add(newInterval);
                }
                result.add(interval);
            } else {

                if (interval[1] < newInterval[0]) {
                    result.add(interval);

                } else {

                    // ***NewInterval mutable***
                    newInterval[0] = Math.min(newInterval[0], interval[0]);
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                }
            }
        }


        if (!inserted) {
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);

    }

    public static void main(String[] args) {
        Solution57 s = new Solution57();

        int[][] intervals1 = new int[][]{{1, 3}, {6, 9}};
        int[] new1 = new int[]{2, 5};
        print2D(s.insert(intervals1, new1)); // expected: [1,5] [6,9]

        int[][] intervals2 = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] new2 = new int[]{4, 8};
        print2D(s.insert(intervals2, new2)); // expected: [1,2] [3,10] [12,16]

        int[][] intervals3 = new int[][]{};
        int[] new3 = new int[]{5, 7};
        print2D(s.insert(intervals3, new3)); // expected: [5,7]

        int[][] intervals4 = new int[][]{{2, 6},{7,9}};
        int[] new4 = new int[]{15, 18};
        print2D(s.insert(intervals4, new4)); // expected: [1,5]


    }

    private static void print2D(int[][] a) {
        if (a == null) {
            System.out.println("null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int[] p : a) {
            sb.append("[").append(p[0]).append(",").append(p[1]).append("] ");
        }
        System.out.println(sb.toString().trim());
    }
}
