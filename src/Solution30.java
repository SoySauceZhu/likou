import java.util.*;

public class Solution30 {
    public List<Integer> findSubstring(String s1, String[] words) {
        List<Integer> result = new ArrayList<>();
        for (int track = 0; track < words[0].length(); track++) {
            String s = s1.substring(track);


            int wordNum = words.length;
            String[] wordList = s.split("(?<=\\G.{" + words[0].length() + "})");

            Map<String, Integer> wordCnt = new HashMap<>();
            for (String w : words) {
                if (!wordCnt.containsKey(w)) {
                    wordCnt.put(w, 1);
                } else {
                    wordCnt.put(w, wordCnt.get(w) + 1);
                }
            }


            int left = 0, right = 0;

            Map<String, Integer> hash = new HashMap<>();
            for (String w : words) {
                hash.put(w, 0);
            }


            while (right < wordList.length) {
                String word = wordList[right++];

                if (!wordCnt.containsKey(word)) {
                    hash.replaceAll((i, v) -> 0);
                    left = right;
                    continue;
                }

                // update window word count
                hash.put(word, hash.get(word) + 1);

                // If this word occurs too much, shrink the window until the previous occurrence is removed.
                // Then setup the flag for this occurrence.
                // ps: always ensure no repeat words in the window
                while (hash.get(word) > wordCnt.get(word)) {
                    String removingWord = wordList[left++];

                    hash.put(removingWord, hash.get(removingWord) - 1);
                }


                // If the word doesn't exist, add to hash table. And check if all words are included in the window.
                // Then append left pointer to result
                if (right - left == wordNum) {
                    result.add(left * words[0].length() + track);
                }

            }
        }

        return result;

    }

    public static void main(String[] args) {
        Solution30 sol = new Solution30();

//        String s1 = "barfoothefoobarman";
//        String[] w1 = {"foo", "bar"};
//        System.out.println(sol.findSubstring(s1, w1)); // expected: [0, 9]
//
//        String s2 = "wordgoodgoodgoodbestword";
//        String[] w2 = {"word", "good", "best", "word"};
//        System.out.println(sol.findSubstring(s2, w2)); // expected: []
//
        String s3 = "barfoofoobarthefoobarman";
        String[] w3 = {"bar", "foo", "the"};
        System.out.println(sol.findSubstring(s3, w3)); // expected: [6, 9, 12]
    }
}
