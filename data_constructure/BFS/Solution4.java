package BFS;
//相同的树
//广度优先搜索

import javax.imageio.plugins.bmp.BMPImageWriteParam;
import javax.xml.transform.Source;
import java.util.Deque;
import java.util.LinkedList;

public class Solution4 {
//    public static void main(String[] args) {
//        Solution4 s1=new Solution4();
//        TreeNode node1=new TreeNode(2);
//        TreeNode root1=new TreeNode(1, node1,null);
//        TreeNode node2=new TreeNode(2);
//        TreeNode root2=new TreeNode(1,null,node2);
//        boolean b=s1.isSameTree(root1,root2);
//        System.out.println(b);
//    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if (p == null || q == null) return false;
        boolean isflag = true;
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.add(p);
        stack2.add(q);
        while (!stack1.isEmpty() && !stack2.isEmpty() && isflag) {
            int size1 = stack1.size();
            int size2 = stack2.size();
            if (size1 != size2) isflag = false;
            else {
                for (int i = 0; i < size1; i++) {
                    TreeNode node1 = stack1.pop();
                    TreeNode node2 = stack2.pop();
                    if (node1.left != null && node2.left == null) {
                        isflag = false;
                        break;
                    } else if (node1.left == null && node2.left != null) {
                        isflag = false;
                        break;
                    } else if (node1.right != null && node2.right == null) {
                        isflag = false;
                        break;
                    } else if (node1.right == null && node2.right != null) {
                        isflag = false;
                        break;
                    }
                    if (node1.left != null) stack1.push(node1.left);
                    if (node1.right != null) stack1.push(node1.right);
                    if (node2.left != null) stack2.push(node2.left);
                    if (node2.right != null) stack2.push(node2.right);
                    isflag = node1.val == node2.val;
                }
            }
        }
        return isflag;
    }
}