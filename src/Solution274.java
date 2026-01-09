import java.util.Arrays;
import java.util.EnumSet;

public class Solution274 {
    public int hIndex(int[] citations) {
        // Sort the citations array in ascending order
        Arrays.sort(citations);

        // Get the total number of papers
        int n = citations.length;

        // Try each possible h-index value from highest to lowest
        for (int h = n; h > 0; h--) {
            // Check if we have at least h papers with h or more citations
            // citations[n - h] is the h-th paper from the end (after sorting)
            // If this paper has at least h citations, then all papers after it
            // (which are h papers total) also have at least h citations
            if (citations[n - h] >= h) {
                return h;
            }
        }

        // If no valid h-index found, return 0
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        Solution274 solution274 = new Solution274();
        System.out.println(solution274.hIndex(citations));
    }
}


//
//
//
//public int hIndex(int[] citations) {
//    int[] count = new int[citations.length + 1];
//
//    for (int citation : citations) {
//        for (int c = 0; c <= citation; c++) {
//            if (c < count.length) {
//                count[c] += 1;
//            }
//        }
//    }
//
//    for (int i = count.length - 1; i >= 0; i--) {
//        if (count[i] >= i) return i;
//    }
//
//    return 0;
//}

