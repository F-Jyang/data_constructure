package DFS;
//后续遍历，递归
import java.util.LinkedList;
import java.util.List;

class Solution4 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list=new LinkedList<>();
        if(root==null)return list;
        if(root.left!=null)DFS(root.left,list);
        if(root.right!=null)DFS(root.right,list);
        list.add(root.val);
        return list;
    }
    private void DFS(TreeNode node,List<Integer> list){
        if(node.left!=null)DFS(node.left,list);
        if(node.right!=null)DFS(node.right,list);
        list.add(node.val);
    }
}
