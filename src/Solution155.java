import java.util.ArrayDeque;
import java.util.Deque;

class Solution155 {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public Solution155() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        int minVal = Math.min(minStack.peek(), val);
        minStack.push(minVal);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
