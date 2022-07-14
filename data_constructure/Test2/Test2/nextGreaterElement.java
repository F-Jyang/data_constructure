package Test2.Test2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer=new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            int number1=nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if(number1==nums2[j]){
                    int ans=-1;
                    for (int k = j; k < nums2.length; k++) {
                        if(nums2[k]>number1) {
                            ans=nums2[k];
                            break;
                        }
                    }
                    answer[i]=ans;
                }
            }
        }
        return answer;
    }
}
