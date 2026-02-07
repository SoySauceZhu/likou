import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution105 {

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

    int[] preorder;
    Map<Integer, Integer> inorderValueToIndex = new HashMap<>();

    private TreeNode dfs(int preStart, int inStart, int n) {
        if (n <= 0) return null;
        int rootValue = preorder[preStart];
        int rootIndexInorder = inorderValueToIndex.get(rootValue);

        int leftTreeSize = rootIndexInorder - inStart;    // leftTree: from preStart to inorderRootIndex
        int rightTreeSize = inStart + n - rootIndexInorder - 1;

        TreeNode left = dfs(preStart + 1, rootIndexInorder - leftTreeSize, leftTreeSize);
        TreeNode right = dfs(preStart + leftTreeSize + 1, rootIndexInorder + 1, rightTreeSize);

        return new TreeNode(rootValue, left, right);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderValueToIndex.put(inorder[i], i);
        }

        return dfs(0, 0, inorder.length);

    }


    public List<Integer> treeToList(TreeNode root) {
        List<Integer> result = new java.util.ArrayList<>();
        java.util.LinkedList<TreeNode> q = new java.util.LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                result.add(null);
                continue;
            }
            result.add(node.val);
            q.add(node.left);
            q.add(node.right);
        }

        int i = result.size() - 1;
        while (i >= 0 && result.get(i) == null) {
            result.remove(i);
            i--;
        }

        return result;
    }


    public static void main(String[] args) {
        Solution105 sol = new Solution105();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = sol.buildTree(preorder, inorder);
        System.out.println(sol.treeToList(root));

    }
}
