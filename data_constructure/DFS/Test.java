package DFS;

public class Test {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(5);
        System.out.println(node);
        TreeNode node2=node.left;
        System.out.println(node2);
        node2=new TreeNode(999);
        System.out.println(node2);
        System.out.println(node.left);
        node.left=node2;
        System.out.println(node.left);
    }
}
