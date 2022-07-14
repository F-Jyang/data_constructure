package HashTable;

import java.util.HashMap;

/*
205. 同构字符串
两种办法
1、第一种自己的效率更高
2、第二种效率较低
 */
//badc\baba
public class isIsomorphic {
    /*public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> maps = new HashMap<>();
        HashMap<Character, Character> mapt = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (maps.containsKey(s.charAt(i))) {
                if (maps.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (mapt.containsKey(t.charAt(i))) {
                    return false;
                }
                maps.put(s.charAt(i), t.charAt(i));
                mapt.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }*/
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> maps = new HashMap<>();
        HashMap<Character, Character> mapt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if ((maps.containsKey(a) && maps.get(a) != b) || (mapt.containsKey(b) && mapt.get(b) != a)) {
                return false;
            }
            maps.put(a, b);
            mapt.put(b, a);
        }
        return true;
    }
}
