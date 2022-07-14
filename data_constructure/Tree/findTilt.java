package Tree;

import java.util.ArrayList;
import java.util.List;

//563、二叉树的坡度
public class findTilt {
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

    int ans;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int sum_left = dfs(node.left);
        int sum_right = dfs(node.right);
        ans += Math.abs(sum_left - sum_right);
        return sum_left - sum_right + node.val;
    }
}
