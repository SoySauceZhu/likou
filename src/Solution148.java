public class Solution148 {

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

    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            len++;
        }

        return sortList(head, len);
    }

    private ListNode sortList(ListNode head, int len) {
        if (len <= 1) {
//            return new ListNode(head.val);
            return head;
        }
//        if (len == 2) {
//            if (head.val > head.next.val) {
//                int t = head.val;
//                head.val = head.next.val;
//                head.next.val = t;
//            }
//        }

        int mid = len / 2;
        ListNode midNode = head;
        for (int i = 0; i < mid - 1; i++) {
            midNode = midNode.next;
        }
        ListNode t = midNode;
        midNode = midNode.next;
        t.next = null;

        ListNode firstHalfPtr = sortList(head, len / 2);
        ListNode secondHalfPtr = sortList(midNode, len - len / 2);

        ListNode newHead = new ListNode();  // sentinel
        ListNode ptr = newHead;

        while (firstHalfPtr != null && secondHalfPtr != null) {
            if (firstHalfPtr.val <= secondHalfPtr.val) {
                ptr.next = new ListNode(firstHalfPtr.val);
                firstHalfPtr = firstHalfPtr.next;
            } else {
                ptr.next = new ListNode(secondHalfPtr.val);
                secondHalfPtr = secondHalfPtr.next;
            }
            ptr = ptr.next;
        }

        if (firstHalfPtr != null) {
            ptr.next = firstHalfPtr;
        } else {
            ptr.next = secondHalfPtr;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        Solution148 s = new Solution148();

        // Example: 4 -> 2 -> 1 -> 3
        ListNode head = s.new ListNode(4,
                s.new ListNode(2,
                        s.new ListNode(1,
                                s.new ListNode(3))));

        head = s.sortList(head);
        printList(head);
    }

    private static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while (cur != null) {
            if (!sb.isEmpty()) sb.append(" -> ");
            sb.append(cur.val);
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }
}
