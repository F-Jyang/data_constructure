package DFS;

import java.util.ArrayList;

//二叉搜索树迭代器
/*
1、中序遍历将搜索树的值存入一个数组中
2、
 */
class BSTIterator {
    int size;
    ArrayList<Integer> list;

    public BSTIterator(TreeNode root) {
        if (root != null) {
            list = new ArrayList<>();
            if (root.left != null) DFS(root.left, list);
            list.add(root.val);
            if (root.right != null) DFS(root.right, list);
        } else {
            size = 0;
        }
    }

    private void DFS(TreeNode node, ArrayList<Integer> list) {
        if (node.left != null) DFS(node.left, list);
        list.add(node.val);
        if (node.right != null) DFS(node.right, list);
    }

    public int next() {
        if (!hasNext()) throw new NullPointerException();
        return list.get(size++);
    }

    public boolean hasNext() {
        return size < list.size();
    }
}

