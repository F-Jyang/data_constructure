package DFS;

public class deleteNode {
    public static void main(String[] args) {
        deleteNode d1 = new deleteNode();
        TreeNode node = new TreeNode(0);
        d1.deleteNode(node, 0);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
     /*   if (root == null) return root;
        TreeNode node = root;
        TreeNode pre = null;
        TreeNode target;
        while (node != null) {
            if (key > node.val) {
                pre = node;
                node = node.right;
            } else if (key < node.val) {
                pre = node;
                node = node.left;
            } else {//找到目标节点后，用左节点的最右边的值代替/右节点的最左值代替/直接为0
                target = node;
                if (target.right != null) {
                    TreeNode leftPre = target;//指向代替删节点的节点的上一个节点
                    TreeNode leftNode = target.right;//代替删除节点的节点
                    while (leftNode.left != null) {//只要左节点不为null则一直循环
                        leftPre = leftNode;
                        leftNode = leftNode.left;
                    }
                    target.val = leftNode.val;
                    //如果被删除节点的左或者右节点没有树叶
                    if (leftNode == target.right) {
                        target.right = null;
                    } else {
                        leftPre.left = null;
                    }
                } else if (target.left != null) {
                    TreeNode rightPre = target;
                    TreeNode rightNode = target.left;
                    while (rightNode.right != null) {
                        rightPre = rightNode;
                        rightNode = rightNode.right;
                    }
                    target.val = rightNode.val;
                    if (rightNode == target.left) {
                        target.left = null;
                    } else {
                        rightPre.right = null;
                    }
                } else {
                    if (target==root) {
                       node=null;
                    } else if (pre.left == target) {
                        pre.left = null;
                    } else {
                        pre.right = null;
                    }
                }

            }
        }
        return root;
    }*/
        /*
        搜索出有无节点：
            如果右节点：
                先找到目标节点
                    删除节点分三种情况：
                    1、节点无树叶：直接删除节点
                    2、右左树叶或者右树叶：寻找前/右驱点代替，然后删除驱点
                    3、左右树叶都存在：同2
         */
        if (root == null) return root;
        TreeNode node = root;
        if (key > node.val) {
            node.right = deleteNode(node.right, key);
        } else if (key < node.val) {
            node.left = deleteNode(node.left, key);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left != null) {
                node.val = predecessor(node);
                node.left = deleteNode(node.left, predecessor(node));
            } else {
                node.val = successor(node);
                node.right = deleteNode(node.right, successor(node));
            }
        }

        return node;
    }

    //得到前驱点
    public int predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) node = node.right;
        return node.val;
    }

    //得到后驱点
    public int successor(TreeNode node) {
        node = node.right;
        while (node.left != null) node = node.left;
        return node.val;
    }
}
