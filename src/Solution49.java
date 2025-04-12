import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = 0;
        Map<String, Integer> map = new HashMap<>();
//        Map<String, Integer> assign = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {

            String sorted = sortedString(str);
            // If not occurred, add a new list to result, assign a new index for groupID
            // If occurred, find the groupID from map, add it to the right group in result
            if (!map.containsKey(sorted)) {
                map.put(sorted, n++);
                result.add(new ArrayList<>());
            }

//            assign.put(str, map.get(sorted));
            result.get(map.get(sorted)).add(str);
        }


//        for (int i = 0; i < n; i++) {
//            result.add(new ArrayList<>());
//        }
//
//        for (Map.Entry<String, Integer> entry : assign.entrySet()) {
//            result.get(entry.getValue()).add(entry.getKey());
//        }
//
        return result;
    }

    private String sortedString(String str) {
        char[] chars = str.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution49 solution = new Solution49();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] input = {"", ""};
        List<List<String>> result = solution.groupAnagrams(input);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
