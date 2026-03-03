import java.util.List;

public class Solution2 {
    class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode res_ptr = sentinel;

        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        int carry = 0;
        while (ptr1 != null && ptr2 != null) {
            int sum = (ptr1.val + ptr2.val + carry) % 10;
            res_ptr.next = new ListNode(sum);
            carry = (ptr1.val + ptr2.val + carry) / 10;
            res_ptr = res_ptr.next;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        while (ptr1 != null) {
            res_ptr.next = new ListNode((ptr1.val + carry) % 10);
            carry = (ptr1.val + carry) / 10;
            res_ptr = res_ptr.next;
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            res_ptr.next = new ListNode((ptr2.val + carry) % 10);
            carry = (ptr2.val + carry) / 10;
            res_ptr = res_ptr.next;
            ptr2 = ptr2.next;
        }
        if (carry != 0) {
            res_ptr.next = new ListNode(carry);
        }

        return sentinel.next;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();

        // helper to build list from digits in reverse order (LeetCode 2 format)
        java.util.function.IntFunction<ListNode> build = (int dummy) -> null;
        java.util.function.Function<int[], ListNode> fromDigits = (int[] digits) -> {
            ListNode sentinel = s.new ListNode(0);
            ListNode cur = sentinel;
            for (int d : digits) {
                cur.next = s.new ListNode(d);
                cur = cur.next;
            }
            return sentinel.next;
        };

        // helper to print list as digits in reverse order
        java.util.function.Consumer<ListNode> print = (ListNode head) -> {
            StringBuilder sb = new StringBuilder();
            ListNode cur = head;
            while (cur != null) {
                if (sb.length() > 0) sb.append(" -> ");
                sb.append(cur.val);
                cur = cur.next;
            }
            System.out.println(sb.toString());
        };
//
//        // Example 1: [2,4,3] + [5,6,4] = [7,0,8]
//        ListNode l1 = fromDigits.apply(new int[]{2, 4, 3});
//        ListNode l2 = fromDigits.apply(new int[]{5, 6, 4});
//        ListNode r1 = s.addTwoNumbers(l1, l2);
//        print.accept(r1);

        // Example 2: [0] + [0] = [0]
        ListNode l3 = fromDigits.apply(new int[]{3, 7});
        ListNode l4 = fromDigits.apply(new int[]{9, 2});
        ListNode r2 = s.addTwoNumbers(l3, l4);
        print.accept(r2);

        // Example 3: [9,9,9,9,9,9,9] + [9,9,9,9] = [8,9,9,9,0,0,0,1]
        ListNode l5 = fromDigits.apply(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l6 = fromDigits.apply(new int[]{9, 9, 9, 9});
        ListNode r3 = s.addTwoNumbers(l5, l6);
        print.accept(r3);
    }
}
