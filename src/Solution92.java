import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution92 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (right - left <= 0) return head;
        ListNode sentinel = new ListNode();
        sentinel.next = head;

        ListNode ptr = sentinel;

        for (int i = 0; i < left - 1; i++) {
            ptr = ptr.next;
        }

        ListNode leftNode = ptr;
        ptr = ptr.next;

        Deque<ListNode> stack = new ArrayDeque<>();

        for (int i = 0; i < right - left; i++) {
            stack.push(ptr);
            ptr = ptr.next;
        }

        stack.push(ptr);
        ListNode rightNode = ptr.next;
        leftNode.next = stack.peek();

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (!stack.isEmpty()) {
                node.next = stack.peek();
            } else {
                node.next = rightNode;
            }
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        Solution92 sol = new Solution92();

//        // Case 1: [1,2,3,4,5], left=2, right=4 -> [1,4,3,2,5]
//        ListNode head1 = sol.new ListNode(1,
//                sol.new ListNode(2,
//                        sol.new ListNode(3,
//                                sol.new ListNode(4,
//                                        sol.new ListNode(5)))));
//        ListNode res1 = sol.reverseBetween(head1, 2, 4);
//        printList(res1);
//
//        // Case 2: [5], left=1, right=1 -> [5]
//        ListNode head2 = sol.new ListNode(5);
//        ListNode res2 = sol.reverseBetween(head2, 1, 1);
//        printList(res2);

        // Case 3: [1,2], left=1, right=2 -> [2,1]
        ListNode head3 = sol.new ListNode(1, sol.new ListNode(2));
        ListNode res3 = sol.reverseBetween(head3, 1, 2);
        printList(res3);
    }

    private static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while (cur != null) {
            if (sb.length() > 0) sb.append("->");
            sb.append(cur.val);
            cur = cur.next;
        }
        System.out.println(sb);
    }
}
