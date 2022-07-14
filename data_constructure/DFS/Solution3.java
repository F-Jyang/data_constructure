package DFS;
import java.util.LinkedList;
import java.util.List;
//中序遍历，递归
/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 */
class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        if (root.left != null) {
            DFS(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            DFS(root.right, list);
        }
        return list;
    }
    private void DFS(TreeNode node, LinkedList<Integer> list) {
        if (node.left != null) {
            DFS(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            DFS(node.right, list);
        }
    }
}
