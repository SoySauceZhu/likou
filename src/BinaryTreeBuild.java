class BinaryTreeBuild {

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


//    public Node connect(Node root) {
//    }

    private Node buildTree(int[] values, int i) {
        if (i >= values.length) return null;

        Node root = new Node(values[i]);
        Node leftChild = buildTree(values, i * 2 + 1);
        Node rightChild = buildTree(values, i * 2 + 2);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    public static void main(String[] args) {
        BinaryTreeBuild sol = new BinaryTreeBuild();

        int[] values = {1, 2, 3, 4, 5, 6, 7};
        Node root = sol.buildTree(values, 0);

        // Basic sanity prints
        System.out.println("root=" + (root == null ? "null" : root.val));
        System.out.println("root.left=" + (root.left == null ? "null" : root.left.val));
        System.out.println("root.right=" + (root.right == null ? "null" : root.right.val));
    }
}