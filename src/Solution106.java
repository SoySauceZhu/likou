import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution106 {
    public class TreeNode {
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

    Map<Integer, Integer> inOrderValueToIndex = new HashMap<>();
    int[] postorder;

    private TreeNode dfs(int inOrderStart, int postOrderStart, int n) {
        if (n <= 0) return null;
        int rootValue = postorder[postOrderStart + n - 1];
        int inOrderRootIndex = inOrderValueToIndex.get(rootValue);

        int leftTreeSize = inOrderRootIndex - inOrderStart;
        int rightTreeSize = inOrderStart + n - inOrderRootIndex - 1;

        TreeNode left = dfs(inOrderStart, postOrderStart, leftTreeSize);
        TreeNode right = dfs(inOrderRootIndex + 1, postOrderStart + leftTreeSize, rightTreeSize);

        return new TreeNode(rootValue, left, right);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            inOrderValueToIndex.put(inorder[i], i);

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
        Solution106 sol = new Solution106();

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = sol.buildTree(inorder, postorder);

        System.out.println(sol.treeToList(root));

    }
}
