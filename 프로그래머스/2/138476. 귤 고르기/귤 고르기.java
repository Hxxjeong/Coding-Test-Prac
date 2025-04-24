import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: tangerine) map.put(i, map.getOrDefault(i, 0)+1);
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        for(Map.Entry<Integer, Integer> entry: list) {
            k -= entry.getValue();
            answer++;
            if(k <= 0) return answer;
        }
        
        return answer;
    }
}