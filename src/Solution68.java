import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        int wordPtr = 0;
        int viewedPtr = 0;
        int lineCharCount = -1;
        while (wordPtr < words.length) {
            int wordCharCount = words[wordPtr].length() + 1;
            if (lineCharCount + wordCharCount > maxWidth) {

                String[] candidates = new String[wordPtr - viewedPtr];
                System.arraycopy(words, viewedPtr, candidates, 0, wordPtr - viewedPtr);
                res.add(justify(candidates, maxWidth));

                viewedPtr = wordPtr;
                lineCharCount = -1;

            }
            lineCharCount += wordCharCount;
            wordPtr++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = viewedPtr; i < wordPtr - 1; i++) {
            sb.append(words[i]).append(" ");
        }
        sb.append(words[wordPtr - 1]);
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }

        res.add(sb.toString());

        return res;
    }

    private String justify(String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();

        int charNum = 0;
        for (String word : words) {
            charNum += word.length();
        }

        // Handle edge condition firstly to simplify logic
        if (words.length == 1) {
            return words[0] + " ".repeat(maxWidth - charNum);
        }

        if (words.length == 0) {
            return null;
        }

        int spaceNum = words.length - 1;

        int[] spaceArr = new int[spaceNum];

        Arrays.fill(spaceArr, (maxWidth - charNum) / spaceNum);

        for (int i = 0; i < (maxWidth - charNum) % spaceNum; i++) {
            spaceArr[i] += 1;
        }

        for (int i = 0; i < spaceNum; i++) {        // spaceNum = words.length - 1
            sb.append(words[i]);
            sb.append(" ".repeat(spaceArr[i]));
        }

        sb.append(words[spaceNum]);

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words =
                {"What", "must", "be", "acknowledgment", "shall", "be"};

        int maxWidth = 16;


        Solution68 solution68_1 = new Solution68();
        List<String> output = solution68_1.fullJustify(words, maxWidth);
        System.out.println(output);
    }
}
