package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;

//[3,9,20,null,null,15,7]
public class minDepth {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(20, node2, node1);
        TreeNode node4 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node4, node3);
        minDepth m1 = new minDepth();
        int i = m1.minDepth(root);
    }

    public int minDepth(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root.left != null) DFS(root.left, list,1);
        if (root.right != null) DFS(root.right, list,1);
        int min=list.get(0);
        for (int i:list) {
            if(i<min)min=i;
        }
        return min;
    }

    private void DFS(TreeNode node, ArrayList<Integer> list, int deep) {
        deep++;
        if (node.left == null && node.right == null) {
            list.add(deep);
            return;
        }
        if (node.left != null) DFS(node.left, list, deep);
        if (node.right != null) DFS(node.right, list, deep);
    }
}
