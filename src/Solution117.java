import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {


            Node rightMost = queue.poll();

            // Do something: Iterate a line
            List<Node> list = new ArrayList<>(queue);
            queue.clear();

            if (rightMost.left != null) queue.offer(rightMost.left);
            if (rightMost.right != null) queue.offer(rightMost.right);

            for (Node n : list) {
                rightMost.next = n;
                rightMost = n;

                if (n.left!= null) queue.offer(n.left);
                if (n.right!= null) queue.offer(n.right);
            }

        }

        return root;
    }

    public static void main(String[] args) {
        Solution117 sol = new Solution117();

        // Build a perfect binary tree:
        //        1
        //      /   \
        //     2     3
        //    / \   / \
        //   4  5  6  7
        Node n1 = sol.new Node(1);
        Node n2 = sol.new Node(2);
        Node n3 = sol.new Node(3);
        Node n4 = sol.new Node(4);
        Node n5 = sol.new Node(5);
        Node n6 = null;
        Node n7 = sol.new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        sol.connect(n1);

        // Print next pointers level by level (using existing next links):
        Node levelStart = n1;
        while (levelStart != null) {
            Node cur = levelStart;
            while (cur != null) {
                int nextVal = (cur.next == null) ? -1 : cur.next.val;
                System.out.print(cur.val + "->" + nextVal + " ");
                cur = cur.next;
            }
            System.out.println("#");
            levelStart = levelStart.left;
        }

        // Expected:
        // 1->-1 #
        // 2->3 3->-1 #
        // 4->5 5->6 6->7 7->-1 #
    }
}
