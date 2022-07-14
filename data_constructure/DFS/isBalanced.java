package DFS;
/*
判断是否为平衡树
平衡树的性质：任何一个节点的左右节点深度差，绝对值小于1
声明两个方法，一个用来判断是否平衡，一个用来计算深度
平衡的条件是根的左右节点深度差绝对值小于等于1，且其左右节点也平衡
    左右节点平衡的条件是其子节点平衡......不断重复
 */
public class isBalanced {
    public boolean isBalanced(TreeNode root) {
        //如果为空则是
        if (root == null) return true;
        //非空则判断左右子树的深度
        return Math.abs(getDeepth(root.left) - getDeepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //定义一个方法，得到左或右子树的深度
    public int getDeepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int right = getDeepth(node.right) + 1;
        int left = getDeepth(node.left) + 1;
        return Math.max(right, left);
    }
}