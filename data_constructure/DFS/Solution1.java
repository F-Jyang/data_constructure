package DFS;
//不用递归,而是用迭代查询
//二叉树前序遍历

import java.util.*;

class Solution1 {
    //定义一个栈(stack已经过时,而deque是stack的升级版),用来存储节点,目的是可以返回上一个节点
    //定义一个链表,用来存储节点的值,最后的答案
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        //特殊情况
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        //这里是重点,如果node是空,则将栈中节点推出,返回上一个节点
        //如果node非空,则推入栈中方便返回上一个节点,继续向左边遍历
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}
