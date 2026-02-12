public class Solution138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node old_ptr = head;
        while (old_ptr != null) {
            Node temp = old_ptr.next;
            old_ptr.next = new Node(old_ptr.val);
            old_ptr.next.next = temp;
            old_ptr.next.random = old_ptr.random;
            old_ptr = old_ptr.next.next;
        }

        Node new_ptr = head;
        Node result = head.next;
        // update random
        while (new_ptr != null) {
            if (new_ptr.next.random != null) {
                new_ptr.next.random = new_ptr.next.random.next;
            }
            new_ptr = new_ptr.next.next;
        }

        new_ptr = head;
        while (new_ptr != null) {
            Node temp = new_ptr.next.next;
            if (new_ptr.next.next != null) {
                new_ptr.next.next = new_ptr.next.next.next;
            }
            new_ptr.next = temp;

            new_ptr = new_ptr.next;
        }

        return result;

    }

    public static void main(String[] args) {
        Solution138 s = new Solution138();

        // Example: [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node n1 = s.new Node(7);
        Node n2 = s.new Node(13);
        Node n3 = s.new Node(11);
        Node n4 = s.new Node(10);
        Node n5 = s.new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Node copy = s.copyRandomList(n1);

        // Print as LeetCode-style pairs: [val, randomIndex] using indices in the copied list
        java.util.Map<Node, Integer> idx = new java.util.HashMap<>();
        int i = 0;
        for (Node p = copy; p != null; p = p.next) idx.put(p, i++);

        StringBuilder out = new StringBuilder();
        out.append("[");
        for (Node p = copy; p != null; p = p.next) {
            out.append("[");
            out.append(p.val).append(",");
            out.append(p.random == null ? "null" : idx.get(p.random));
            out.append("]");
            if (p.next != null) out.append(",");
        }
        out.append("]");
        System.out.println(out);
    }

}
