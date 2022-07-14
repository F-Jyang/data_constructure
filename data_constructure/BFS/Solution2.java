package BFS;
//二叉树的层序遍历
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> answer = new LinkedList<>();
        if (root == null) return answer;
        queue.add(root);

        LinkedList<Integer> rootlist = new LinkedList<Integer>();
        rootlist.add(root.val);
        answer.add(rootlist);

        while (!queue.isEmpty()) {
//            LinkedList<Integer> list=new LinkedList<>();
//            while(!queue.isEmpty()) {1
//                node = queue.poll();
//                if (node.left != null) {
//                    list.add(node.left.val);
//                }
//                if (node.right != null) {
//                    list.add(node.right.val);
//                }
//                queue.add(node.left);
//                queue.add(node.right);
//                if (!list.isEmpty()) answer.add(list);
//
//            }
//遇到的问题：如何让一个list添加一层的节点的值而不是一个节点下面的两个节点的值的值？
            LinkedList<Integer> list = new LinkedList<>();
//可以利用queue.size，指定一个size次的for循环，这样poll()出去的节点就是上一层的所有节点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    list.add(node.left.val);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right.val);
                    queue.add(node.right);
                }
            }
//而list内的值也是当前层的值
            if (!list.isEmpty()) answer.add(list);
//一次for之后，queue里面的节点是当前层的节点，因为上一层的size个节点已经被poll()出去了
        }
        return answer;
    }
}

