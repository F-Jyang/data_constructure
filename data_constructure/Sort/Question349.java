package Sort;

import java.util.ArrayList;

public class Question349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans=new ArrayList<>();
        for (int k : nums1) {
            for (int i : nums2) {
                if (k == i) ans.add(k);
            }
        }
        int[] answer=new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i]=ans.get(i);
        }
        return answer;
    }
}
