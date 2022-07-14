package DFS;
//节点为空
//节点的值在这个范围内
//节点的值超过这个范围
/*
用递归的时候可以将当前写的方法当作递归时重复遍历的方法
假设该方法被调用时，我们需要考虑多少种情况？？？（重要）
 */
public class rangeSumBST2 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val >= low && root.val <= high) return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        else return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

    }
}
