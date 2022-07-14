package DFS;
/*
有序数组构造平衡树
思路：
因为是有序数组，所以我们要取数组中间的数作为根节点
接下来我们可以将数组分成左右两块
根的左节点为左边的数组的中间的值，而根的右节点为右边数组的中间的值
左节点的左节点和右节点的右节点也同理，不断分割数组，直到数组的左边索引大于右边索引
 */
public class sortedArrayToBST {
    public static void main(String[] args) {
        int[] nums={-10,-3,0,5,9};
        sortedArrayToBST s1=new sortedArrayToBST();
        TreeNode root=s1.sortedArrayToBST(nums);
        TreeNode node=root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
