package HashTable;

import java.util.HashMap;
import java.util.HashSet;

/*
771. 宝石与石头
 */
public class numJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set=new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        int sum=0;
        for (int i = 0; i < stones.length(); i++) {
            if(set.contains(stones.charAt(i))){
                sum++;
            }
        }
        return sum;
    }
}
