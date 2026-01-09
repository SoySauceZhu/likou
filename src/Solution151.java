public class Solution151 {
    public String reverseWords(String s) {
//        String[] strings = s.split(" ");
//        int idx = 0;
//        for (int i = 0; i < strings.length; i++) {
//            if (!strings[i].isEmpty()) {
//                strings[idx++] = strings[i];
//            }
//        }

        String[] strings = s.strip().split("\\s+");
        int idx = strings.length;

        StringBuilder sb = new StringBuilder();
        for (int i = idx - 1; i >= 0; i--) {
            sb.append(strings[i]).append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        String s = "hello world  ";
        System.out.println(solution151.reverseWords(s));
    }
}
