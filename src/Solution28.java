public class Solution28 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);

//        if (haystack.length() < needle.length()) return  -1;
//        int needle_ptr;
//        int haystack_ptr = 0;
//
//        while (haystack_ptr < haystack.length()) {
//            if (haystack.charAt(haystack_ptr) == needle.charAt(0)) {
//                for (needle_ptr = 0; needle_ptr < needle.length() && haystack_ptr + needle_ptr < haystack.length(); needle_ptr++) {
//                    if (haystack.charAt(haystack_ptr + needle_ptr) != needle.charAt(needle_ptr)) {
//                        needle_ptr = 0;
//                        break;
//                    }
//                }
//                if (needle_ptr == needle.length() ) return haystack_ptr;
//                needle_ptr = 0;
//            }
//
//            haystack_ptr++;
//        }
//        return -1;
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        String s = "mississippi", n = "issipi";
        System.out.println(solution28.strStr(s, n));
    }
}
