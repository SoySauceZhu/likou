import java.util.ArrayDeque;
import java.util.Deque;

public class Solution71 {
    public String simplifyPath(String path) {
        Deque<String> stk = new ArrayDeque<>();
        for (String s : path.split("/")) {
            if (s.equals(".") || s.isEmpty()) continue;

            if (s.equals("..")) {
                stk.pollLast();
            } else {
                stk.addLast(s);
            }

        }
        return "/" + String.join("/", stk);
    }

    public static void main(String[] args) {
            Solution71 sol = new Solution71();

            String[] tests = {
                    "/home/",
                    "/../",
                    "/home//foo/",
                    "/a/./b/../../c/",
                    "/a/../../b/../c//.//",
                    "/a//b////c/d//././/.."
            };

            for (String t : tests) {
                System.out.println(t + " -> " + sol.simplifyPath(t));
            }
        }
}
