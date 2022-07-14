package DFS;

//求路径总和
class Solution8 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //这里卡bug了，root.val==targetSum,如果只有根节点则true,如果还有其他节点则为false；
        if(root==null)return false;//既是最后的退出条件，也是可以判断根节点
        if(root.left==null&&root.right==null&&targetSum-root.val==0)return true;
        //记住，归出了可以用+，还可以用-
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}