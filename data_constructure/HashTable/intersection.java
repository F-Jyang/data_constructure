package HashTable;

import java.util.HashSet;

/*
两个数组的交集
 */
public class intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        /*HashSet<Integer> set=new HashSet<>();
        for (int i:nums1) {
            for (int j:nums2) {
                if(i==j){
                    set.add(i);
                    break;
                }
            }
        }
        int[] ans=new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            ans[i]=(int)set.toArray()[i];
        }
        return ans;*/
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        for (int i:nums1) {
            set1.add(i);
        }
        for (int i:nums2) {
            if(set1.contains(i)){
                set2.add(i);
            }
        }
        int[] ans=new int[set2.size()];
        int j=0;
        for (int i:set2) {
            ans[j++]=i;
        }
        return ans;
    }
}
