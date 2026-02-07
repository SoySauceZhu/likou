import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class Solution150 {
    // 遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中

    public int evalRPN(String[] tokens) {
        Deque<String> stk = new ArrayDeque<>();
        int operandA;
        int operandB;

        for (String token : tokens) {

            if (token.equals("+")) {
                operandA = Integer.parseInt(stk.poll());
                operandB = Integer.parseInt(stk.poll());
                stk.push(Integer.toString(operandB + operandA));
                continue;
            }
            if (token.equals("-")) {
                operandA = Integer.parseInt(stk.poll());
                operandB = Integer.parseInt(stk.poll());
                stk.push(Integer.toString(operandB - operandA));
                continue;
            }
            if (token.equals("*")) {
                operandA = Integer.parseInt(stk.poll());
                operandB = Integer.parseInt(stk.poll());
                stk.push(Integer.toString(operandA * operandB));
                continue;
            }
            if (token.equals("/")) {
                operandA = Integer.parseInt(stk.poll());
                operandB = Integer.parseInt(stk.poll());
                stk.push(Integer.toString(operandB / operandA));
                continue;
            } else {
                stk.push(token);
            }
        }

        return Integer.parseInt(stk.poll());
    }

    public static void main(String[] args) {
        Solution150 sol = new Solution150();

        // Example 1: 9
        System.out.println(sol.evalRPN(new String[]{"2", "1", "+", "3", "*"}));

        // Example 2: 6
        System.out.println(sol.evalRPN(new String[]{"4", "13", "5", "/", "+"}));

        // Example 3: 22
        System.out.println(sol.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));

        // Additional sanity checks
        // -4
        System.out.println(sol.evalRPN(new String[]{"3", "4", "-"}));

        // 0 (integer division truncates toward 0)
        System.out.println(sol.evalRPN(new String[]{"1", "3", "/"}));
    }

}
