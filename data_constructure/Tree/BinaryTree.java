package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//二叉树作业
public class BinaryTree<T extends Comparable<T>> {
    public static void main(String[] args) {
        //建立树并添加测试节点
        BinaryTree<Integer> myTree = new BinaryTree<>(10);
        myTree.root.left = new TreeNode<>(8);
        myTree.root.right = new TreeNode<>(123);
        myTree.root.left.right = new TreeNode<>(9);
        myTree.root.left.left = new TreeNode<>(1);
        myTree.root.right.left = new TreeNode<>(11);
        myTree.root.right.right = new TreeNode<>(222);

        //测试isSorted方法
        System.out.println(myTree.isSorted());
        //测试parent方法
        TreeNode<Integer> temp = new TreeNode<>(11);
        System.out.println(myTree.parent(temp).val);
        //测试remove方法
        System.out.println(myTree.remove(temp).val);
        //测试property3方法
        System.out.println(property3(myTree.root));
        //测试swap方法
        System.out.println("反转前：");
        myTree.preOrder(myTree.root);
        swap(myTree.root);
        System.out.println("\n反转后：");
        myTree.preOrder(myTree.root);

        HashMap<Integer,Integer> map =new HashMap<>();
    }

    TreeNode<T> root = new TreeNode<>();

    public BinaryTree(T val) {
        root = new TreeNode<>(val);
    }

    /**
     * #Description 前序遍历（迭代），并打印
     * @param
     * @return
     * @author jiongyang
     * #Date 2022/5/21
     */
    public void preOrder(TreeNode<T> root){
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            if(root==null)continue;
            stack.push(root.right);
            stack.push(root.left);
            System.out.print(root.val+" ");
        }
    }

    /**
     * #Description 返回父结点 时间复杂度为 n ，n 为树的结点数量
     * @param 
     * @return 
     * @author jiongyang
     * #Date 2022/5/21
     */
    public TreeNode<T> parent(TreeNode<T> node) {
        if (node == null) return null;
        return parent(root, node.val);
    }

    private TreeNode<T> parent(TreeNode<T> node, T val) {
        if (node == null) return null;
        if (node.left != null && node.left.val == val) return node;
        if (node.right != null && node.right.val == val) return node;
        TreeNode<T> left_node = parent(node.left, val);
        return left_node == null ? parent(node.right, val) : left_node;
    }

    /**
     * #Description 删除子树并返回根节点 时间复杂度为 n ，n 为树的结点数量
     * @param
     * @return
     * @author jiongyang
     * #Date 2022/5/21
     */
    public TreeNode<T> remove(TreeNode<T> node) {
        if (node == null) return null;
        return remove(root, node.val);
    }

    private TreeNode<T> remove(TreeNode<T> node, T val) {
        if (node == null) return null;
        if (node.left != null && node.left.val == val) {
            TreeNode<T> left_node = node.left;
            node.left = null;
            return left_node;
        }
        if (node.right != null && node.right.val == val) {
            TreeNode<T> right_node = node.right;
            node.right = null;
            return right_node;
        }
        TreeNode<T> left_node = remove(node.left, val);
        TreeNode<T> right_node = remove(node.right, val);
        return left_node == null ? right_node : left_node;
    }

    /**
     * #Description 判断是否为二叉搜索树 时间复杂度为 n ，n 为树的结点数量
     * @param 
     * @return 
     * @author jiongyang
     * #Date 2022/5/21
     */
    public boolean isSorted() {
        return isSorted(root);
    }

    private boolean isSorted(TreeNode<T> node) {
        Stack<TreeNode<T>> stack = new Stack<>();
        T min = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                if (min == null) min = node.val;
                if (node.val.compareTo(min) < 0) return false;
                else min = node.val;
                node = node.right;
            }
        }
        return true;
    }

    /**
     * #Description 反转二叉树  时间复杂度为 n ，n为树的结点数量
     * @param 
     * @return 
     * @author jiongyang
     * #Date 2022/5/21
     */
    public static <T extends Comparable<T>> void swap(TreeNode<T> root) {
        if (root == null) return;
        TreeNode<T> left_node = root.left;
        TreeNode<T> right_node = root.right;
        root.left = right_node;
        root.right = left_node;
        swap(root.left);
        swap(root.right);
    }
    /**
     * #Description 性质3 时间复杂度为 n ，n 为树的节点数目
     * @param
     * @return
     * @author jiongyang
     * #Date 2022/5/21
     */
    public static <T extends Comparable<T>> boolean property3(TreeNode<T> root) {
        List<TreeNode<T>> list_zero = new ArrayList<>();
        List<TreeNode<T>> list_two = new ArrayList<>();
        property3(root, list_zero, list_two);
        return list_zero.size() == list_two.size() + 1;
    }

    private static <T extends Comparable<T>> void property3(TreeNode<T> root, List<TreeNode<T>> list_zero, List<TreeNode<T>> list_two) {
        if (root == null) return;
        if (root.left == null && root.right == null) list_zero.add(root);
        if (root.left != null && root.right != null) list_two.add(root);
        if (root.left != null) property3(root.left, list_zero, list_two);
        if (root.right != null) property3(root.right, list_zero, list_two);
    }


    //节点类
    static class TreeNode<T extends Comparable<T>> {
        T val;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode() {
        }

        TreeNode(T val) {
            this.val = val;
        }

        TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
