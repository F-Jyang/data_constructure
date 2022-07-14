package HashTable;

import java.beans.beancontext.BeanContext;
import java.util.*;

public class topKFrequent {
    public static void main(String[] args) {
        System.out.println();
    }


    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(nums[i])) {
                maps.put(nums[i], maps.get(nums[i]) + 1);
            } else {
                maps.put(nums[i], 1);
            }
        }
        int maxTime = 0;
        //如何根据哈希表的value对key进行排序
        //首先得到最大出现次数
        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {//这个是foreach使用map的方法
            if (entry.getValue() > maxTime) {
                maxTime = entry.getValue();
            }
        }
        //将最大次数依次与maps的值比较，如果匹配则maps--且将对应的key存入数组ans中
        int index = 0;
        while (index < k) {
            for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
                if (entry.getValue() == maxTime) {
                    ans[index++] = entry.getKey();
                }
            }
            maxTime--;
        }
        return ans;
    }
}
