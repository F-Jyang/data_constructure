package DFS;
//判断是否为搜索二叉树
//节点的左子树只包含 小于 当前节点的数。
//节点的右子树只包含 大于 当前节点的数。
//所有左子树和右子树自身必须也是二叉搜索树。

import java.util.ArrayList;

/*
1、考虑特殊情况
2、
 */
class Solution10 {
    public boolean isValidBST(TreeNode root) {
        if(root==null)return false;
        if(root.left == null && root.right == null)return true;
        boolean isflag=true;
        ArrayList<Integer> list=new ArrayList<>();
        if(root.left!=null)DFS(root.left,list);
        list.add(root.val);
        if(root.right!=null)DFS(root.right,list);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                isflag = false;
                break;
            }
        }
        return isflag;
    }
    private void DFS(TreeNode node,ArrayList<Integer> list){
        if(node.left!=null)DFS(node.left,list);
        list.add(node.val);
        if(node.right!=null)DFS(node.right,list);
    }
}