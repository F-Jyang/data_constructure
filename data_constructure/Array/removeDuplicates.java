package Array;

public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p=1,l=1;
        while (l < nums.length) {
            if (nums[l]!=nums[l-1]) {
                nums[p]=nums[l];
                p++;
            }
            l++;
        }
        return p;
    }
}
