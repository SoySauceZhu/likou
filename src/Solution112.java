public class Solution112 {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int cnt) {
        if (root == null) {
            return false;
        }

        cnt -= root.val;
        if (cnt == 0 && root.left == null && root.right == null) {
            return true;
        } else {
            return dfs(root.left, cnt) || dfs(root.right, cnt);
        }


    }
}
