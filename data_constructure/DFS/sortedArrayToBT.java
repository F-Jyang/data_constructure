package DFS;

/*
将一个数组转换为二叉树的方法
1、如果为空数组，则为null
2、
 */
public class sortedArrayToBT {
    public static void main(String[] args) {
        int[] nums={-10,-3,0,5,9};
        sortedArrayToBT s1=new sortedArrayToBT();
        TreeNode root=s1.sortedArrayToBT(nums);
        TreeNode node=root;
    }
    public TreeNode sortedArrayToBT(int[] nums) {
        if (nums == null) return null;
        TreeNode root = new TreeNode(nums[nums.length/2]);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > root.val) {
                root.right = insert(root.right, nums[i]);
            } else if (nums[i] < root.val) {
                root.left = insert(root.left, nums[i]);
            }
        }
        return root;
    }

    private TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (root.val < value) {
            root.right = insert(root.right, value);
        } else if (root.val > value) {
            root.left = insert(root.left, value);
        }
        return root;
    }
}
