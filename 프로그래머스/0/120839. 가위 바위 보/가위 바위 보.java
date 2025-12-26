import java.util.*;

class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 0);
        map.put(0, 5);
        map.put(5, 2);
        
        for(char c: rsp.toCharArray())
            sb.append(map.get(c - '0'));
        
        return sb.toString();
    }
}