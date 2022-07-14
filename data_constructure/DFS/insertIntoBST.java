package DFS;

import java.util.LinkedList;

//与根节点判断大小
//等于返回根节点
//大于返回右节点
//小于返回左节点
//当节点为空时创建一个新节点
//[4,2,7,1,3]
//5
//二叉搜索树的插入操作
public class insertIntoBST {
    public static void main(String[] args) {
        insertIntoBST ist = new insertIntoBST();
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2, node6, node5);
        TreeNode node9 = new TreeNode(4, node8, node7);
        TreeNode node = ist.insertIntoBST(node9, 5);
        System.out.println(node.val);
    }

    /*
        //问题：找到空节点位置后如何将值插入
        public TreeNode insertIntoBST(TreeNode root, int val) {
            //为空时插入给节点赋值
            //当传入root的是7的左节点（null）时，为什么new一个节点后，7的左节点还是为null？？？
            if (root == null) {
                return new TreeNode(val);
            }
            //大于节点值，传入右节点
            if (val > root.val) {
                root.right=insertIntoBST(root.right, val);
            }
            //小于节点值，传入左节点
            if (val < root.val) {
                root.left=insertIntoBST(root.left, val);
            }
            return root;
        }*/
/*    public TreeNode insertIntoBST(TreeNode root, int val) {

     //为空时插入给节点赋值
        //当传入root的是7的左节点（null）时，为什么new一个节点后，7的左节点还是为null？？？
        if (root == null) {
            root= new TreeNode(val);
        }
        //大于节点值，传入右节点
        if (val > root.val) {
            insertIntoBST(root.right, val);
        }
        //小于节点值，传入左节点
        if (val < root.val) {
            insertIntoBST(root.left, val);
        }
        return root;
    }*/
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = root;
        while (node != null) {
            if (val > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            } else if (val < node.val) {
                if (node.left== null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            }
        }
        return root;
    }
}
