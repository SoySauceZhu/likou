import java.util.List;

public class Solution21 {
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

//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode ptr1 = list1;
//        ListNode ptr2 = list2;
//        ListNode sentinel = new ListNode();
//        ListNode ptr = sentinel;
//
//        while (ptr1 != null && ptr2 != null) {
//            if (ptr1.val > ptr2.val) {
//                ptr.next = new ListNode(ptr2.val);
//                ptr2 = ptr2.next;
//            } else {
//                ptr.next = new ListNode(ptr1.val);
//                ptr1 = ptr1.next;
//            }
//            ptr = ptr.next;
//        }
//
//        if (ptr2 != null) {
//            ptr.next = ptr2;
//        }
//
//        if (ptr1 != null) {
//            ptr.next = ptr1;
//        }
//
//        return sentinel.next;
//    }


    /*
        O(1) Space
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode();
        ListNode ptr = sentinel;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ptr.next = list1;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                list2 = list2.next;
            }
            ptr = ptr.next;
        }

        return sentinel.next;
    }


    public static void main(String[] args) {
        Solution21 sol = new Solution21();

        // list1 = \[1,2,4\]
        ListNode list1 = sol.new ListNode(1, sol.new ListNode(2, sol.new ListNode(4)));
        // list2 = \[1,3,4\]
        ListNode list2 = sol.new ListNode(1, sol.new ListNode(3, sol.new ListNode(4)));

        ListNode merged = sol.mergeTwoLists(list1, list2);

        StringBuilder sb = new StringBuilder();
        sb.append("\\[");
        ListNode cur = merged;
        while (cur != null) {
            sb.append(cur.val);
            cur = cur.next;
            if (cur != null) sb.append(",");
        }
        sb.append("\\]");

        System.out.println(sb.toString()); // expected: \[1,1,2,3,4,4\]
    }
}