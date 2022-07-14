package DFS;
//递归 二叉树的前序遍历
import java.util.LinkedList;
import java.util.List;

class Solution2 {
    //定义一个链表用来接收答案
    LinkedList<Integer> list = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        //考虑特殊情况
        if(root==null)return list;
        list.add(root.val);
        //如果左边不为空就先对左边进行深度优先查询
        if (root.left != null) {
            DFS(root.left);
        }
        if (root.right != null) {
            DFS(root.right);
        }
        return list;
    }
    //1\首先处理传入的值
    //2\在进行下一步判断和调用递归
    public void DFS(TreeNode node) {
        list.add(node.val);
        if (node.left!= null) {
            DFS(node.left);
        }
        if (node.right != null) {
            DFS(node.right);
        }
    }
}


