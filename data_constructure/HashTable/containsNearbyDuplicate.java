package HashTable;

import java.util.HashSet;

public class containsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] - nums[j] == 0 && j - i <= k) {
                    return true;
                }
            }
        }
        return false;*/
        HashSet<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (set.size() > k) {
                set.remove(nums[i - k - 1]);
            }
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3};
        containsNearbyDuplicate c = new containsNearbyDuplicate();
        c.containsNearbyDuplicate(arr, 2);
    }
}