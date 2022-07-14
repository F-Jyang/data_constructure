package BFS;
import java.util.Deque;
import java.util.LinkedList;

class Solution3 {
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        Deque<TreeNode> stack=new LinkedList<>();
        int maxDeep=0;
        stack.add(root);
        //一个for表示遍历了一层，所以在每个for之前maxDeep++；
        while (!stack.isEmpty()){
            maxDeep++;
            int size=stack.size();
            //这里注意要提前声明当前层的size
            //不能在for循环中“i<stack.size()”，因为stack.size()一直在改变
            for (int i = 0; i < size; i++) {
                TreeNode node=stack.pop();
                if(node.left!=null){
                    stack.add(node.left);
                }
                if(node.right!=null){
                    stack.add(node.right);
                }
            }
        }
        return maxDeep;
    }
}


