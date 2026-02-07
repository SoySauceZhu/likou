import java.util.*;

public class Solution56 {
    public int[][] merge(int[][] list) {

//        list.sort((a, b) -> a[0] - b[0]);
//        Collections.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(list, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        result.add(list[0]);

        for (int i = 1; i < list.length; i++) {
            int[] top = result.get(result.size() - 1);
            result.remove(result.size() - 1);
            if (list[i][0] <= top[1]) {
                //merge
                result.add(new int[]{top[0], Math.max(list[i][1], top[1])});
            } else {
                // put both back
                result.add(top);
                result.add(list[i]);
            }
        }

        return result.toArray(new int[result.size()][]);

    }

    public static void main(String[] args) {
        Solution56 s = new Solution56();

        int[][] intervals1 = new int[][]{{1, 3}, {8, 10}, {15, 18}, {2, 6}};
        int[][] merged1 = s.merge(intervals1);
        System.out.println(java.util.Arrays.deepToString(merged1)); // expected: [[1, 6], [8, 10], [15, 18]]

        int[][] intervals2 = new int[][]{{1, 4}, {2,3}};
        int[][] merged2 = s.merge(intervals2);
        System.out.println(java.util.Arrays.deepToString(merged2)); // expected: [[1, 5]]
    }
}
