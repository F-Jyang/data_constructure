package DFS;
//递归判断树是否对称

public class Solution5 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode q, TreeNode p) {
        if (q == null && p == null) {
            return true;
        }
        if (q == null || p == null) {
            return false;
        }
        return q.val == p.val && check(q.left, p.right)&&check(q.right,p.left);
    }
}
