package Sort;

public class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i; j >= 0 && nums[j + 1] > nums[j]; j--) {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
        }
        return nums[k - 1];
    }
}
