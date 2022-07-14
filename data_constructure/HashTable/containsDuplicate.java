package HashTable;
/*
数组是否存在重复元素
 */
import java.util.HashSet;

public class containsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{3,3}));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        int size=nums.length;
        for (int i = 0; i < size; i++) {
            if(set.contains(nums[i])){
                return true;
            }
            else set.add(nums[i]);
        }
        return false;
    }
}
