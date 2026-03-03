import java.util.List;

public class Solution19 {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode fast = sentinel;
        for (int i = 0; i < n; i++) {
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode slow = sentinel;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        Solution19 s = new Solution19();

            // Case 1: [1,2,3,4,5], n=2 -> [1,2,3,5]
            ListNode head1 = s.new ListNode(1,
                    s.new ListNode(2,
                            s.new ListNode(3,
                                    s.new ListNode(4,
                                            s.new ListNode(5)))));
            head1 = s.removeNthFromEnd(head1, 2);
            printList(head1); // expected: 1\->2\->3\->5

        // Case 2: [1], n=1 -> []
        ListNode head2 = s.new ListNode(1);
        head2 = s.removeNthFromEnd(head2, 1);
        printList(head2); // expected: empty

        // Case 3: [1,2], n=1 -> [1]
        ListNode head3 = s.new ListNode(1, s.new ListNode(2));
        head3 = s.removeNthFromEnd(head3, 1);
        printList(head3); // expected: 1

        // Case 4: [1,2], n=2 -> [2]
        ListNode head4 = s.new ListNode(1, s.new ListNode(2));
        head4 = s.removeNthFromEnd(head4, 2);
        printList(head4); // expected: 2
    }

    private static void printList(ListNode head) {
        ListNode cur = head;
        if (cur == null) {
            System.out.println("empty");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) sb.append("->");
            cur = cur.next;
        }
        System.out.println(sb);
    }
}
