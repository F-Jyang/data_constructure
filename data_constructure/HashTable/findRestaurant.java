package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
599. 两个列表的最小索引总和——找交集
 */
public class findRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        String[] ans=new String[1];
        HashMap<Integer,String> map1=new HashMap<>();
        HashMap<Integer,String> map2=new HashMap<>();
        int index1=0;
        for (String s:list1){
            map1.put(index1++,s);
        }
        int index2=0;
        for (String s:list2){
            map2.put(index2++,s);
        }
        int sum=list1.length;
        for (int i = 0; i < map1.size(); i++) {
            for (int j = 0; j < map2.size(); j++) {
                if(map1.get(i).equals(map2.get(j))&&sum>i+j){
                    sum=i+j;
                    ans[0]=map1.get(i);
                }
            }
        }
        return ans;
    }
}
