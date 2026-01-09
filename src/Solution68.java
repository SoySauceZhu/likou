import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution68 {
    // TODO: this question is too boring

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        for (int i = 0, n = words.length; i < n;) {
            List<String> t = new ArrayList<>();
            t.add(words[i]);
            int cnt = words[i].length();
            ++i;
            while (i < n && cnt + 1 + words[i].length() <= maxWidth) {
                cnt += 1 + words[i].length();
                t.add(words[i++]);
            }
            if (i == n || t.size() == 1) {
                String left = String.join(" ", t);
                String right = " ".repeat(maxWidth - left.length());
                ans.add(left + right);
                continue;
            }
            int spaceWidth = maxWidth - (cnt - t.size() + 1);
            int w = spaceWidth / (t.size() - 1);
            int m = spaceWidth % (t.size() - 1);
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < t.size() - 1; ++j) {
                row.append(t.get(j));
                row.append(" ".repeat(w + (j < m ? 1 : 0)));
            }
            row.append(t.get(t.size() - 1));
            ans.add(row.toString());
        }
        return ans;
    }


    public static void main(String[] args) {
        String[] words =
                {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};

        int maxWidth = 20;


        Solution68 solution68_1 = new Solution68();
        List<String> output = solution68_1.fullJustify(words, maxWidth);
        for (String s : output) {
            System.out.println(s);
        }
    }
}


//    public List<String> fullJustify(String[] words, int maxWidth) {
//        List<String> res = new ArrayList<>();
//
//        int wordPtr = 0;
//        int viewedPtr = 0;
//        int lineCharCount = -1;
//        while (wordPtr < words.length) {
//            int wordCharCount = words[wordPtr].length() + 1;
//            if (lineCharCount + wordCharCount > maxWidth) {
//
//                String[] candidates = new String[wordPtr - viewedPtr];
//                System.arraycopy(words, viewedPtr, candidates, 0, wordPtr - viewedPtr);
//                res.add(justify(candidates, maxWidth));
//
//                viewedPtr = wordPtr;
//                lineCharCount = -1;
//
//            }
//            lineCharCount += wordCharCount;
//            wordPtr++;
//        }
//
//
//        // TODO: This can reuse justify()
//        StringBuilder sb = new StringBuilder();
//        for (int i = viewedPtr; i < wordPtr - 1; i++) {
//            sb.append(words[i]).append(" ");
//        }
//        sb.append(words[wordPtr - 1]);
//        while (sb.length() < maxWidth) {
//            sb.append(" ");
//        }
//
//        res.add(sb.toString());
//
//        return res;
//    }
//
//    private String justify(String[] words, int maxWidth) {
//        StringBuilder sb = new StringBuilder();
//
//        int charNum = 0;
//        for (String word : words) {
//            charNum += word.length();
//        }
//
//        // Handle edge condition firstly to simplify logic
//        // TODO: last row can be handled here
//        if (words.length == 1) {
//            return words[0] + " ".repeat(maxWidth - charNum);
//        }
//
//        if (words.length == 0) {
//            return null;
//        }
//
//        int spaceNum = words.length - 1;
//
//        int[] spaceArr = new int[spaceNum];
//
//        Arrays.fill(spaceArr, (maxWidth - charNum) / spaceNum);
//
//        for (int i = 0; i < (maxWidth - charNum) % spaceNum; i++) {
//            spaceArr[i] += 1;
//        }
//
//        for (int i = 0; i < spaceNum; i++) {        // spaceNum = words.length - 1
//            sb.append(words[i]);
//            sb.append(" ".repeat(spaceArr[i]));
//        }
//
//        sb.append(words[spaceNum]);
//
//        return sb.toString();
//    }
//

