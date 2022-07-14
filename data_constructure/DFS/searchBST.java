package DFS;

//二叉搜索树中的搜索
/*
1、考虑特殊情况
2、传入根节点，判断与根节点与左右节点的值大小
    值小于节点值，判断左节点
    值大于节点值，判断右节点
 */
public class searchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (val == root.val) return root;
        if (val < root.val && root.left != null) return searchBST(root.left, val);
        if (val > root.val && root.right != null) return searchBST(root.right, val);
        return null;
    }
}
