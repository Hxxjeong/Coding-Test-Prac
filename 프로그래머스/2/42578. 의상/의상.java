import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0)+1);
        }
        
        for(int i: map.values()) {
            answer *= i+1;  // 하나 고르기 + 고르지 않기(1)
        }

        return answer-1;    // 아무것도 안 고르는 경우 제외
    }
}