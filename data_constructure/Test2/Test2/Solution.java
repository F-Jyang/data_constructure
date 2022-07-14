package Test2.Test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set=new HashSet<>();
        ArrayList<String> second=new ArrayList<>();
        String end=null;
        for (List<String> path : paths) {
            set.add(path.get(0));
            second.add(path.get(1));
        }
        for (String s:second) {
            if(!set.contains(s))end=s;
        }
        return end;
    }
}
