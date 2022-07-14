package DFS;
//迭代 二叉树的中序遍历

import java.util.*;

/*
1、对root一直while循环到最左边的节点并且压入栈中
2、当到达某个节点，它的左指针为null时（现在指针指向null）
    出栈一个节点，将这个节点当做根节点，添加当前节点的值，
    再将指针指向右节点
    (右节点成为根节点！！！也就是说我们的指针一直指向根节点，
    而内部while的作用是得到一个左节点为null的子树，然后我们可以直接添加根节点的值进答案)
    重复过程1：得到（null,root.val,指向root.right）
3、如果右节点为空时，出栈当前根节点的根节点，添加根节点的值，继续指向右节点
    不为空则右节点变成了根节点，继续向左遍历至左节点为空
 */
public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        //问题：如何添加完左边的点后，它的值添加到答案中，然后回到根节点，在添加右节点
        while (root!=null||!stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root=root.right;
        }
        return list;
    }
}
