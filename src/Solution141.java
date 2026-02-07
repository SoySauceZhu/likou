import java.util.List;

public class Solution141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        ListNode sl = head;
        if (sl == null)
            return false;
        if (sl.next == null)
            return false;

        ListNode fs = head.next;

        while (fs.next != null && fs.next.next != null) {
            if (fs == sl)
                return true;

            fs = fs.next.next;
            sl = sl.next;
        }

        return false;

    }
}
