import javax.swing.text.EditorKit;
import java.util.ArrayList;
import java.util.List;

/*
    // Discussion about iterative/recursive, stack/queue, dfs/bfs


    // Iterative method. Works both fine for DFS and BFS
void search(Node start) {
    // ---------------------------------------------------------
    // 如果这里container用 Stack，就是 DFS
    // 如果这里container用 Queue，就是 BFS
    // ---------------------------------------------------------

    Container container = new Stack() / new Queue();

    container.add(start);

    while (!container.isEmpty()) {
        // 1. 取出一个节点
        // Stack 会取出最新放进去的 (LIFO) -> 导致一直往深处钻
        // Queue 会取出最早放进去的 (FIFO) -> 导致一层层处理
        Node current = container.remove();

        process(current);

        // 2. 将邻居放入容器
        for (Node neighbor : current.neighbors) {
            container.add(neighbor);
        }
    }
}

 */
public class Solution17 {
    char[][] keyboard = new char[][]{{},                 // 0
            {},                 // 1
            {'a', 'b', 'c'},    // 2
            {'d', 'e', 'f'},    // 3
            {'g', 'h', 'i'},    // 4
            {'j', 'k', 'l'},    // 5
            {'m', 'n', 'o'},    // 6
            {'p', 'q', 'r', 's'}, // 7
            {'t', 'u', 'v'},    // 8
            {'w', 'x', 'y', 'z'} // 9
    };

    public List<String> letterCombinations(String digits) {
        /*
            Iterative : BFS. using queue
         */
//
//
//        List<String> result = new ArrayList<>();
//        result.add("");
//        for (int c : digits.toCharArray()) {
//            char[] key = keyboard[c - '0'];
//
//            List<String> temp = new ArrayList<>();
//
//            for (char newLetter : key) {
//                for (String oldString : result) {
//                    temp.add(oldString + newLetter);
//                }
//            }
//
//            result = temp;
//        }
//
//        return result;


        if (digits.isEmpty()) return ans;
        this.digits = digits;
        dfs(0);
        return ans;

    }


    /*
        BackTracing ：Recursive DFS. using stack.
        But here the stack is not explicitly maintained,
        we use recursive function call (system stack)
     */
    private String digits;
    private List<String> ans = new ArrayList<>();
    private StringBuilder t = new StringBuilder();

    private void dfs(int i) {
        // build "adh", then "adh", then "adi" => Backtracing

        if (i >= digits.length()) {
            ans.add(t.toString());
            return;
        }

        int digit = Integer.parseInt(String.valueOf(digits.charAt(i)));

        for (char c : keyboard[digit]) {
            t.append(c);
            dfs(i + 1);
            t.deleteCharAt(t.length() - 1);
        }
    }


    public static void main(String[] args) {
        Solution17 s = new Solution17();

        System.out.println(s.letterCombinations("23")); // [ad, ae, af, bd, be, bf, cd, ce, cf]
        System.out.println(s.letterCombinations(""));   // []
        System.out.println(s.letterCombinations("2"));  // [a, b, c]
    }
}
