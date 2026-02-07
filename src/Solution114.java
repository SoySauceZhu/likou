import java.util.ArrayDeque;
import java.util.Deque;

public class Solution114 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode newRoot = new TreeNode();
        TreeNode newPtr = newRoot;
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            newPtr.right = new TreeNode(p.val);
            newPtr = newPtr.right;

            if (p.right != null) stack.push(p.right);
            if (p.left != null) stack.push(p.left);

        }
        root.right = newRoot.right.right;
        root.left = null;
    }

    public static void main(String[] args) {
            Solution114 sol = new Solution114();

            // Build sample tree: [1,2,5,3,4,null,6]
            //     1
            //    / \
            //   2   5
            //  / \   \
            // 3   4   6
            TreeNode root = sol.new TreeNode(1);
            root.left = sol.new TreeNode(2);
            root.right = sol.new TreeNode(5);
            root.left.left = sol.new TreeNode(3);
            root.left.right = sol.new TreeNode(4);
            root.right.right = sol.new TreeNode(6);

            sol.flatten(root);

            // Print flattened list via right pointers
            TreeNode p = root;
            while (p != null) {
                System.out.print(p.val);
                if (p.right != null) System.out.print(" -> ");
                if (p.left != null) System.out.print(" (left not null!)");
                p = p.right;
            }
            System.out.println();
        }
}
