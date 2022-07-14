package HashTable;

import java.util.HashMap;

public class firstUniqChar {
    public int firstUniqChar(String s) {
        /*HashMap<Character, Integer> maps = new HashMap<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            maps.put(s.charAt(i), maps.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if(maps.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }*/
        int[] arr=new int[26];
        int len=s.length();
        for (int i = 0; i < len; i++) {
            arr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < len; i++) {
            if(arr[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        firstUniqChar f1=new firstUniqChar();
        f1.firstUniqChar("leetcode");
    }
}
