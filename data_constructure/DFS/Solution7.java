package DFS;
//判断是否是相同的树
//使用递归
/*
两棵树到达节点后的几种情况：
1、两棵树的节点为null，返回true
2、一个为null，一个不为null
3、两棵树的节点均不为null：两颗树的值不相同，返回false,
                       值相同继续递归（判断当前节点的左右是否相同）
 */
class Solution7 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if(p == null || q == null)return false;
        return p.val==q.val&&isSameTree(q.left,p.left)&&isSameTree(q.right,p.right);
    }
}