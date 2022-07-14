package PriorityQueue;

import java.util.Arrays;
import java.util.HashMap;

//[10,3,8,9,4]
public class findRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, String> map = new HashMap<>();
        int[] clone = score.clone();
        String[] ans = new String[score.length];
        Arrays.sort(clone);
        for (int i = score.length-1; i >= 0; i--) {
            if (i == score.length-1) {
                map.put(clone[i], "Gold Medal");
            } else if (i == score.length-2) {
                map.put(clone[i], "Silver Medal");
            } else if (i == score.length-3) {
                map.put(clone[i], "Bronze Medal");
            } else {
                map.put(clone[i], Integer.toString(ans.length-i));
            }
        }
        for (int i = 0; i <score.length ; i++) {
            ans[i]=map.get(score[i]);
        }
        return ans;
    }
}
