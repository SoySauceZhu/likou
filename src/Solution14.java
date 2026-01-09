public class Solution14 {

    public String longestCommonPrefix(String[] strs) {
        char[] chars = strs[0].toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            // Detect if there is any string doesn't match the prefix
            // If it doesn't match, stop and return
            for (String s : strs) {
                if (i >= s.length() || c != s.charAt(i)) {
                    return sb.toString();
                }
            }

            // If all string match prefix, append
            sb.append(c);
        }

        return sb.toString();
    }
}
