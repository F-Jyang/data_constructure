package DFS;

class Solution9 {
    public static void main(String[] args) {
        //[5,4,8,11,null,13,4,7,2,null,null,null,1]
        Solution9 s9 = new Solution9();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4, null, node1);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(11, node3, node2);
        TreeNode node7 = new TreeNode(8, node5, node4);
        TreeNode node8 = new TreeNode(4, node6, null);
        TreeNode node9 = new TreeNode(5, node8, node7);
        boolean b1 = s9.hasPathSum(node9, 22);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        //这里卡bug了，root.val==targetSum,如果只有根节点则true,如果还有其他节点则为false；
        if (root == null) return false;//既是最后的退出条件，也是可以判断根节点
        return method(root.val, targetSum, root);
    }

    private boolean method(int sum, int targetSum, TreeNode node) {
        if (node == null) return false;
        if (node.left == null && node.right == null && sum + node.val == targetSum) return true;
        return method(sum + node.val, targetSum, node.left) || method(sum + node.val, targetSum, node.right);
    }
}
//class Solution8 {
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        //这里卡bug了，root.val==targetSum,如果只有根节点则true,如果还有其他节点则为false；
//        if(root==null)return false;//既是最后的退出条件，也是可以判断根节点
//        if(root.left==null&&root.right==null&&targetSum-root.val==0)return true;
//        //记住，归出了可以用+，还可以用-
//        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
//    }
//}