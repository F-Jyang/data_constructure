package HashTable;

import java.util.HashMap;

public class findLHS {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i : nums) {
            maps.put(i, maps.getOrDefault(i, 0) + 1);
        }
        int res=0;
        for (int key:maps.keySet()) {
            if(maps.containsKey(key+1)){
                res=Math.max(res,maps.get(key)+maps.get(key+1));
            }
        }
        return res;
    }
}
