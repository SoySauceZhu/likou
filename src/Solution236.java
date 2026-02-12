import java.util.ArrayDeque;
import java.util.Deque;

public class Solution236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Deque<TreeNode> pS = new ArrayDeque<>();
    private Deque<TreeNode> qS = new ArrayDeque<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, pS);
        dfs(root, q, qS);

        TreeNode result = root;

        while (!pS.isEmpty() && !qS.isEmpty()) {
            if (pS.peekLast().val == qS.peekLast().val) {
                result = pS.pollLast();
                qS.pollLast();
            } else {
                break;
            }
        }
        return result;
    }

    private boolean dfs(TreeNode root, TreeNode p, Deque<TreeNode> stack) {
        if (root == null) {
            return false;
        }

        stack.push(root);

//        if (p == root) {
        if (p.val == root.val) {
            return true;
        }


        if (dfs(root.left, p, stack) || dfs(root.right, p, stack)) {
            return true;
        }

        // BackTracing. The target node isn't in the subsequent tree.
        // So the current ptr node is definitely not a part of the path
        stack.pop();
        return false;
    }

    public TreeNode anotherImplementation_DivideAndConquer(TreeNode root, TreeNode p, TreeNode q) {

        // the return value of recursive function is either: p, q, LCA

        // --- 1. Base Case (终止条件 / 汇报) ---
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        // --- 2. Divide (分 / 递归下潜) ---
        // 在左边节点的这个subtree里，p q的最LCA
        // 如果没有LCA(p q不同时在这个左subtree里)，就把能找到的那个target node 返回一下。 让 left = p 或 right = q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // --- 3. Conquer / Merge (治 / 汇总决策) ---

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }

        return null;
    }

    public static void main(String[] args) {
            Solution236 sol = new Solution236();

            // Build the sample tree:
            //        3
            //      /   \
            //     5     1
            //    / \   / \
            //   6   2 0   8
            //      / \
            //     7   4
            TreeNode root = sol.new TreeNode(3);
            root.left = sol.new TreeNode(5);
            root.right = sol.new TreeNode(1);
            root.left.left = sol.new TreeNode(6);
            root.left.right = sol.new TreeNode(2);
            root.right.left = sol.new TreeNode(0);
            root.right.right = sol.new TreeNode(8);
            root.left.right.left = sol.new TreeNode(7);
            root.left.right.right = sol.new TreeNode(4);

//            TreeNode p = root.left; // 5
//            TreeNode q = root.right; // 1
//            TreeNode lca = sol.lowestCommonAncestor(root, p, q);
//            System.out.println("LCA(5, 1) = " + (lca == null ? "null" : lca.val)); // expected 3
//
            TreeNode p2 = root.left; // 5
            TreeNode q2 = root.left.right.right; // 4
            TreeNode lca2 = sol.lowestCommonAncestor(root, p2, q2);
            System.out.println("LCA(5, 4) = " + (lca2 == null ? "null" : lca2.val)); // expected 5
        }

}
