package DFS;
//二叉搜索树中两个节点之和

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class findTarget {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        boolean isflag = false;
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(i) + list.get(j) == k) {
                    isflag = true;
                    break;
                }
            }
        }
        return isflag;
    }
}
